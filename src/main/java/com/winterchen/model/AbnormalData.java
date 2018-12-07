package com.winterchen.model;

import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class AbnormalData {
    private String label;

    private Integer id;

    private Date timestamp;

    private String ip;

    private Integer type;

    private Double inputVolt;

    private Double outputVolt;

    private String version;

    private Double dcdcReferenceVolt;

    private Double dcacReferencePower;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Double getInputVolt() {
        return inputVolt;
    }

    public void setInputVolt(Double inputVolt) {
        this.inputVolt = inputVolt;
    }

    public Double getOutputVolt() {
        return outputVolt;
    }

    public void setOutputVolt(Double outputVolt) {
        this.outputVolt = outputVolt;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public Double getDcdcReferenceVolt() {
        return dcdcReferenceVolt;
    }

    public void setDcdcReferenceVolt(Double dcdcReferenceVolt) {
        this.dcdcReferenceVolt = dcdcReferenceVolt;
    }

    public Double getDcacReferencePower() {
        return dcacReferencePower;
    }

    public void setDcacReferencePower(Double dcacReferencePower) {
        this.dcacReferencePower = dcacReferencePower;
    }
}