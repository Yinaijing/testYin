package com.winterchen.model;

import java.util.Date;

public class responseArduino {

    private String id;

    private String deviceName;

    public void setId(String id) {
        this.id = id;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getId() {
        return id;
    }

    public String getDeviceName() {
        return deviceName;
    }

    private Integer temperatureF;

    private Integer temperatureC;

    private Integer humidity;

    private String code;

    private Date time;

    public void setTemperatureF(Integer temperatureF) {
        this.temperatureF = temperatureF;
    }

    public void setTemperatureC(Integer temperatureC) {
        this.temperatureC = temperatureC;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getTemperatureF() {
        return temperatureF;
    }

    public Integer getTemperatureC() {
        return temperatureC;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public String getCode() {
        return code;
    }

    public Date getTime() {
        return time;
    }

    public responseArduino(String id,String deviceName, Integer temperatureF, Integer temperatureC, Integer humidity, String code, Date time) {
        this.id = id;
        this.deviceName = deviceName;
        this.temperatureF = temperatureF;
        this.temperatureC = temperatureC;
        this.humidity = humidity;
        this.code = code;
        this.time = time;
    }
}
