package com.winterchen.mqtt.protocol.mqttImp.Handler;

import com.winterchen.Springboot2MybatisDemoApplication;
import com.winterchen.controller.DataController;
import com.winterchen.model.arduino;
import com.winterchen.model.exceptionArduino;
import com.winterchen.model.responseArduino;
import com.winterchen.service.user.ArduinoService;
import com.winterchen.service.user.impl.ArduinoImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DBHandler {
    private static List<responseArduino> responseArduinos = new ArrayList<responseArduino>();
    public void saveArduino(arduino au){
        responseArduino reArduino;
        ArduinoService arduinoService = Springboot2MybatisDemoApplication.getBean(ArduinoImpl.class);
        if(au.getTemperatureC() == 0 && au.getHumidity() == 0 && au.getTemperatureF() == 0){//异常数据
            reArduino = new responseArduino("#002","device1",au.getTemperatureF(), au.getTemperatureC(), au.getHumidity(), "002", new Date());
            arduinoService.addExceptionArduino(new exceptionArduino(au.getTemperatureF(), au.getTemperatureC(), au.getHumidity()));
        } else {
            arduinoService.addArduino(au);
            reArduino = new responseArduino("#002","device1",au.getTemperatureF(), au.getTemperatureC(), au.getHumidity(), "001", new Date());
        }

        //前台传数据
        responseArduinos.add(reArduino);
    }
    public List<responseArduino> getResponseArduinos(){
        List<responseArduino> au = new ArrayList<responseArduino>();
        au.addAll(responseArduinos);
        responseArduinos.clear();
        return au;
    }
}
