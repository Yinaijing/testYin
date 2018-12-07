package com.winterchen.service.user.impl;

import com.winterchen.dao.AbnormalDataMapper;
import com.winterchen.dao.dataMapper;
import com.winterchen.model.AbnormalData;
import com.winterchen.model.data;
import com.winterchen.model.datas;
import com.winterchen.service.user.dataService;
import com.winterchen.util.GetTime;
import com.winterchen.util.Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
/**
 * @author miaojinlong
 * @create 2018-11-12-15:49
 **/
@Service
public class dataServiceImpl implements dataService {

    private static List<AbnormalData> Ablist = new ArrayList<>();
    List<datas> lst = new ArrayList<>();

    private static final String abTableName = "data_ab";
    private static final String tablePreName = "data_";
    private static final String tableAbPreName = "abdata_";
    private static final int SEC = 1;

    @Autowired
    private dataMapper dataMapper1;
    @Autowired
    private AbnormalDataMapper AbnormalDataMapper1;

    @Override
    public int insert(data dataObject) {
        return dataMapper1.insertSelective(dataObject);
    }

    @Override
    public int existTable(String tableName){
        return dataMapper1.existTable(tableName);
    }

    @Override
    public int createTable(String tableName){
        return dataMapper1.createTable(tableName);
    }

    @Override
    public int insertList(List<data> list){
        return dataMapper1.insertList(list);
    }

    @Override
    public int insertByTableName(String tableName,data dataObject){
        return dataMapper1.insertByTableName(tableName,dataObject);
    }

    @Override
    public data selectByPrimaryKey(Integer id){
        return dataMapper1.selectByPrimaryKey(id);
    }

    @Override
    public int createAbTable(String abTableName){
        return AbnormalDataMapper1.createAbTable(abTableName);
    }

    @Override
    public double avgVoltAb(String ip,String beginDay,String endDay){
        return AbnormalDataMapper1.avgVoltAb(ip,beginDay,endDay);
    }


    @Override
    public List<AbnormalData> selectAb(String ip,String t1,String t2){
        return AbnormalDataMapper1.selectAb(ip,t1,t2);
    }

    @Override
    public List<datas> getDatas(int id,String time,String ip){
        lst.clear();
        List<data> listData = new ArrayList<>();
        List<data> listAbData = new ArrayList<>();

        String tableName = tablePreName + Hash.getSuffix(ip);
        String tableAbName = tableAbPreName + Hash.getSuffix(ip);

        String beginTime = GetTime.getDateTime(time,(-1)*SEC);
        String endTime = GetTime.getDateTime(time,SEC);

        listData.addAll(dataMapper1.selectDatas(tableName,beginTime,endTime,ip));
        listAbData.addAll(dataMapper1.selectDatas(tableAbName,beginTime,endTime,ip));

        getDatas(listData,-1);
        getDatas(listAbData,id);

        Collections.sort(lst);
        return lst;
    }

    public List<datas> getDatas(List<data> list,int id){
        if (id < 0){
            for(int i = 0; i < list.size(); i++){
                datas da = new datas();
                da.setD(list.get(i));
                da.setType("1");
                lst.add(da);
            }
        }
        else{
            for(int i = 0; i < list.size(); i++){
                datas da = new datas();
                da.setD(list.get(i));
                da.setType("-1");
                if (list.get(i).getId() == id){
                    da.setType("0");
                }
                lst.add(da);
            }
        }
        return lst;
    }

    @Override
    public void insertAb(data record){
        AbnormalData abdata = new AbnormalData();
        if (Math.floor(record.getOutputVolt())%2 == 1){
            abdata.setLabel("AbnormalData-----");
            abdata.setTimestamp(record.getTimestamp());
            abdata.setIp(record.getIp());
            abdata.setType(record.getType());
            abdata.setInputVolt(Math.floor(record.getInputVolt()));
            abdata.setOutputVolt(Math.floor(record.getOutputVolt()));
            abdata.setVersion(record.getVersion());
            abdata.setDcacReferencePower(Math.floor(record.getDcacReferencePower()));
            abdata.setDcdcReferenceVolt(Math.floor(record.getDcdcReferenceVolt()));
            Ablist.add(abdata);
            createTable(abTableName);
            AbnormalDataMapper1.insertAb(abdata);
        }
    }

    @Override
    public List<AbnormalData> getRealtimeAb(){
        return Ablist;
    }

    @Override
    public void ClearList(){
        Ablist.clear();
    }

}
