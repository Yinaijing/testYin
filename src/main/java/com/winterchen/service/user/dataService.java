package com.winterchen.service.user;

import com.winterchen.model.AbnormalData;
import com.winterchen.model.data;
import com.winterchen.model.datas;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author miaojinlong
 * @create 2018-11-12-15:47
 **/
public interface dataService {

    /**
     * @param dataObject data实体类
     * @return
     */
    int insert(data dataObject);

    int existTable(String tableName);

    int createTable(String tableName);

    int createAbTable(String abTableName);

    int insertList(List<data> list);

    int insertByTableName(String tableName, data dataObject);

    void insertAb(data record);

    double avgVoltAb(String ip,String beginDay,String endDay);

    data selectByPrimaryKey(Integer id);

    List<AbnormalData> selectAb(String ip,String t1, String t2);

    List<AbnormalData> getRealtimeAb();

    void ClearList();

    List<datas> getDatas(int id,String time,String ip);
}
