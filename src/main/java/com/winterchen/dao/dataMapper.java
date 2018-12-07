package com.winterchen.dao;

import com.winterchen.model.data;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

public interface dataMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(data record);

    int insertSelective(data record);

    data selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(data record);

    int updateByPrimaryKey(data record);

    int existTable(String tableName);

    int createTable(String tableName);

    int insertList(List<data>list);

    int insertByTableName(String tableName,data dataObject);

    data getTime(@Param("id") int id);

    List<data> selectAbDatas(@Param("beginTime")String beginTime, @Param("endTime")String endTime,@Param("id")int id);
}