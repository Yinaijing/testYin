package com.winterchen.model;

public class exceptionArduino {
    private Integer id;

    private Integer temperatureF;

    private Integer temperatureC;

    private Integer humidity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTemperatureF() {
        return temperatureF;
    }

    public void setTemperatureF(Integer temperatureF) {
        this.temperatureF = temperatureF;
    }

    public Integer getTemperatureC() {
        return temperatureC;
    }

    public void setTemperatureC(Integer temperatureC) {
        this.temperatureC = temperatureC;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public exceptionArduino(int temperatureF,int temperatureC,int humidity) {
        this.humidity = humidity;
        this.temperatureF = temperatureF;
        this.temperatureC = temperatureC;
    }
}