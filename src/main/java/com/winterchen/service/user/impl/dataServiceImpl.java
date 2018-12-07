package com.winterchen.service.user.impl;

import com.winterchen.dao.AbnormalDataMapper;
import com.winterchen.dao.dataMapper;
import com.winterchen.model.AbnormalData;
import com.winterchen.model.data;
import com.winterchen.model.datas;
import com.winterchen.service.user.dataService;
import com.winterchen.util.GetTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
//import com.winterchen.util.GetTime;
/**
 * @author miaojinlong
 * @create 2018-11-12-15:49
 **/
@Service
public class dataServiceImpl implements dataService {

    private static List<AbnormalData> Ablist = new ArrayList<>();
    private static final String abTableName ="data_ab";

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
    public List<datas> getDatas(int id,int sec){
        List<datas> lst = new ArrayList<>();
        List<data> list1 = new ArrayList<>();
        List<data> list2 = new ArrayList<>();

        datas da = new datas();
        da.setD(dataMapper1.getTime(id));
        da.setType("0");
        lst.add(0,da);
        Date t = dataMapper1.getTime(id).getTimestamp();
        String beginTime = GetTime.getDateTime(t,(-1)*sec);
        String endTime = GetTime.getDateTime(t,sec);
        list1.addAll(dataMapper1.selectDatas(beginTime,endTime));
        list2.addAll(dataMapper1.selectAbDatas(beginTime,endTime,id));

        for(int i = 0; i < list1.size(); i++){
            da = new datas();
            da.setD(list1.get(i));
            da.setType("1");
            lst.add(i+1,da);
        }

        for(int i = 0; i < list2.size(); i++){
            da = new datas();
            da.setD(list2.get(i));
            da.setType("-1");
            lst.add(i+1+list1.size(),da);
        }
        Collections.sort(lst);
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

    /**
     * 功能：就觉得这个可不可以写到insertAb2里面去呢？？？？这样可以定义少一个接口。
     * @return
     */
    @Override
    public List<AbnormalData> getRealtimeAb(){
        return Ablist;
    }

    @Override
    public void ClearList(){
        Ablist.clear();
    }

    @Override
    public data getTime(int id){
        return dataMapper1.getTime(id);
    }

    /*QueryInformationResponseVo returnVo = null;
    int count = 0;
    //收集页面信息
    List<PrpCmain> blPrpCmain = new ArrayList<PrpCmain>();
    List<QueryInformationResponseVo> returnList = new ArrayList<QueryInformationResponseVo>();
    TreeSet seqKey = new TreeSet(sequence.keySet());
    Iterator it = seqKey.iterator();
				    while(it.hasNext()){
        returnVo = new QueryInformationResponseVo();//循环一次重新声明
        String flag = (String)it.next();
        prpCmainSchema = (PrpCmain)sequence.get(flag);
        PrpCitemcar  dbPrpCitemCarItem = new PrpCitemcar();
        dbPrpCitemCarItem = (PrpCitemcar)cItemCarTable.get(prpCmainSchema.getPolicyNo());
        returnVo.setFlag(flag);
        returnVo.setPolicyNo(prpCmainSchema.getPolicyNo());
        returnVo.setCarOwner(dbPrpCitemCarItem.getCarOwner());
        returnVo.setLicenseNo(dbPrpCitemCarItem.getLicenseNo());
        returnVo.setEngineNo(dbPrpCitemCarItem.getEngineNo());
        returnVo.setFrameNo(dbPrpCitemCarItem.getFrameNo());
        returnVo.setInsuredName(prpCmainSchema.getInsuredName());
        returnVo.setStartDate(StringUtils.dateTimeToStr(prpCmainSchema.getStartDate()));
        returnVo.setEndDate(StringUtils.dateTimeToStr(prpCmainSchema.getEndDate()));
        returnVo.setPolicyNo(prpCmainSchema.getPolicyNo());
        String comName = prpDcompanyApi.translateCodeByPK(prpCmainSchema.getComCode());
        returnVo.setComName(comName);
        returnList.add(returnVo);
        count++;
    }*/
}
