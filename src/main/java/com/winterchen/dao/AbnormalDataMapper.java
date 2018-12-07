package com.winterchen.dao;

import com.winterchen.model.AbnormalData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AbnormalDataMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(AbnormalData record);

    AbnormalData selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AbnormalData record);

    int updateByPrimaryKey(AbnormalData record);

    int createAbTable(String abTableName);

    int insertAb(AbnormalData record);

    double avgVoltAb(@Param("ip") String ip,@Param("beginDay") String beginDay,@Param("endDay") String endDay);

    List<AbnormalData> selectAb(@Param("ip")String ip, @Param("t1")String t1, @Param("t2")String t2);
}