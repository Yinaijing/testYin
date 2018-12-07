package com.winterchen.dao;

import com.winterchen.model.exceptionArduino;

public interface exceptionArduinoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(exceptionArduino record);

    int insertSelective(exceptionArduino record);

    exceptionArduino selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(exceptionArduino record);

    int updateByPrimaryKey(exceptionArduino record);
}