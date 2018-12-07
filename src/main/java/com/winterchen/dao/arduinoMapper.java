package com.winterchen.dao;

import com.winterchen.model.arduino;

public interface arduinoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(arduino record);

    int insertSelective(arduino record);

    arduino selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(arduino record);

    int updateByPrimaryKey(arduino record);
}