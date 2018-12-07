package com.winterchen.model;

import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class data {
    private Integer id;

    private Date timestamp;

    private String ip;

    private String iapState;

    private Integer type;

    private Integer operatingState;

    private Integer stationState;

    private Double inputVolt;

    private Double inputCurr;

    private Double outputVolt;

    private Double outputCurr;

    private Double coilCurr;

    private Double inverterTemp;

    private Double outputPower;

    private Double batMaxVolt;

    private Double batMaxCurr;

    private Double remainingChargingTime;

    private String version;

    private Integer dcdcState;

    private Double dcdcReferenceVolt;

    private Double dcdcOutputVolt;

    private Double dcdcOutputCurr;

    private Integer dcacState;

    private Double dcacInputVolt;

    private Double dcacInputCurr;

    private Double dcacReferencePower;

    private Double dcacOutputPower;

    private Double dcacTempIgbt1;

    private Double dcacTempIgbt2;

    private Double dcacTempResonantInductor;

    private Double dcacTempTransformer;

    private Double dcacInsulationResistance;

    private Double dcacTempCoil;

    private Integer ivuState;

    private Double ivuRelayVolt;

    private Double ivuBatChargingVolt;

    private Double ivuBatChargingCurr;

    private Double ivuBatMaxVolt;

    private Double ivuBatMaxCurr;

    private Double ivuChargedEnergy;

    private Double ivuRemainingChargingTime;

    private Integer soc;

    private Double ivuTempCoil1;

    private Double ivuTempCoil2;

    private Double ivuTempIgbt1;

    private Double ivuTempIgbt2;

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

    public String getIapState() {
        return iapState;
    }

    public void setIapState(String iapState) {
        this.iapState = iapState == null ? null : iapState.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getOperatingState() {
        return operatingState;
    }

    public void setOperatingState(Integer operatingState) {
        this.operatingState = operatingState;
    }

    public Integer getStationState() {
        return stationState;
    }

    public void setStationState(Integer stationState) {
        this.stationState = stationState;
    }

    public Double getInputVolt() {
        return inputVolt;
    }

    public void setInputVolt(Double inputVolt) {
        this.inputVolt = inputVolt;
    }

    public Double getInputCurr() {
        return inputCurr;
    }

    public void setInputCurr(Double inputCurr) {
        this.inputCurr = inputCurr;
    }

    public Double getOutputVolt() {
        return outputVolt;
    }

    public void setOutputVolt(Double outputVolt) {
        this.outputVolt = outputVolt;
    }

    public Double getOutputCurr() {
        return outputCurr;
    }

    public void setOutputCurr(Double outputCurr) {
        this.outputCurr = outputCurr;
    }

    public Double getCoilCurr() {
        return coilCurr;
    }

    public void setCoilCurr(Double coilCurr) {
        this.coilCurr = coilCurr;
    }

    public Double getInverterTemp() {
        return inverterTemp;
    }

    public void setInverterTemp(Double inverterTemp) {
        this.inverterTemp = inverterTemp;
    }

    public Double getOutputPower() {
        return outputPower;
    }

    public void setOutputPower(Double outputPower) {
        this.outputPower = outputPower;
    }

    public Double getBatMaxVolt() {
        return batMaxVolt;
    }

    public void setBatMaxVolt(Double batMaxVolt) {
        this.batMaxVolt = batMaxVolt;
    }

    public Double getBatMaxCurr() {
        return batMaxCurr;
    }

    public void setBatMaxCurr(Double batMaxCurr) {
        this.batMaxCurr = batMaxCurr;
    }

    public Double getRemainingChargingTime() {
        return remainingChargingTime;
    }

    public void setRemainingChargingTime(Double remainingChargingTime) {
        this.remainingChargingTime = remainingChargingTime;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public Integer getDcdcState() {
        return dcdcState;
    }

    public void setDcdcState(Integer dcdcState) {
        this.dcdcState = dcdcState;
    }

    public Double getDcdcReferenceVolt() {
        return dcdcReferenceVolt;
    }

    public void setDcdcReferenceVolt(Double dcdcReferenceVolt) {
        this.dcdcReferenceVolt = dcdcReferenceVolt;
    }

    public Double getDcdcOutputVolt() {
        return dcdcOutputVolt;
    }

    public void setDcdcOutputVolt(Double dcdcOutputVolt) {
        this.dcdcOutputVolt = dcdcOutputVolt;
    }

    public Double getDcdcOutputCurr() {
        return dcdcOutputCurr;
    }

    public void setDcdcOutputCurr(Double dcdcOutputCurr) {
        this.dcdcOutputCurr = dcdcOutputCurr;
    }

    public Integer getDcacState() {
        return dcacState;
    }

    public void setDcacState(Integer dcacState) {
        this.dcacState = dcacState;
    }

    public Double getDcacInputVolt() {
        return dcacInputVolt;
    }

    public void setDcacInputVolt(Double dcacInputVolt) {
        this.dcacInputVolt = dcacInputVolt;
    }

    public Double getDcacInputCurr() {
        return dcacInputCurr;
    }

    public void setDcacInputCurr(Double dcacInputCurr) {
        this.dcacInputCurr = dcacInputCurr;
    }

    public Double getDcacReferencePower() {
        return dcacReferencePower;
    }

    public void setDcacReferencePower(Double dcacReferencePower) {
        this.dcacReferencePower = dcacReferencePower;
    }

    public Double getDcacOutputPower() {
        return dcacOutputPower;
    }

    public void setDcacOutputPower(Double dcacOutputPower) {
        this.dcacOutputPower = dcacOutputPower;
    }

    public Double getDcacTempIgbt1() {
        return dcacTempIgbt1;
    }

    public void setDcacTempIgbt1(Double dcacTempIgbt1) {
        this.dcacTempIgbt1 = dcacTempIgbt1;
    }

    public Double getDcacTempIgbt2() {
        return dcacTempIgbt2;
    }

    public void setDcacTempIgbt2(Double dcacTempIgbt2) {
        this.dcacTempIgbt2 = dcacTempIgbt2;
    }

    public Double getDcacTempResonantInductor() {
        return dcacTempResonantInductor;
    }

    public void setDcacTempResonantInductor(Double dcacTempResonantInductor) {
        this.dcacTempResonantInductor = dcacTempResonantInductor;
    }

    public Double getDcacTempTransformer() {
        return dcacTempTransformer;
    }

    public void setDcacTempTransformer(Double dcacTempTransformer) {
        this.dcacTempTransformer = dcacTempTransformer;
    }

    public Double getDcacInsulationResistance() {
        return dcacInsulationResistance;
    }

    public void setDcacInsulationResistance(Double dcacInsulationResistance) {
        this.dcacInsulationResistance = dcacInsulationResistance;
    }

    public Double getDcacTempCoil() {
        return dcacTempCoil;
    }

    public void setDcacTempCoil(Double dcacTempCoil) {
        this.dcacTempCoil = dcacTempCoil;
    }

    public Integer getIvuState() {
        return ivuState;
    }

    public void setIvuState(Integer ivuState) {
        this.ivuState = ivuState;
    }

    public Double getIvuRelayVolt() {
        return ivuRelayVolt;
    }

    public void setIvuRelayVolt(Double ivuRelayVolt) {
        this.ivuRelayVolt = ivuRelayVolt;
    }

    public Double getIvuBatChargingVolt() {
        return ivuBatChargingVolt;
    }

    public void setIvuBatChargingVolt(Double ivuBatChargingVolt) {
        this.ivuBatChargingVolt = ivuBatChargingVolt;
    }

    public Double getIvuBatChargingCurr() {
        return ivuBatChargingCurr;
    }

    public void setIvuBatChargingCurr(Double ivuBatChargingCurr) {
        this.ivuBatChargingCurr = ivuBatChargingCurr;
    }

    public Double getIvuBatMaxVolt() {
        return ivuBatMaxVolt;
    }

    public void setIvuBatMaxVolt(Double ivuBatMaxVolt) {
        this.ivuBatMaxVolt = ivuBatMaxVolt;
    }

    public Double getIvuBatMaxCurr() {
        return ivuBatMaxCurr;
    }

    public void setIvuBatMaxCurr(Double ivuBatMaxCurr) {
        this.ivuBatMaxCurr = ivuBatMaxCurr;
    }

    public Double getIvuChargedEnergy() {
        return ivuChargedEnergy;
    }

    public void setIvuChargedEnergy(Double ivuChargedEnergy) {
        this.ivuChargedEnergy = ivuChargedEnergy;
    }

    public Double getIvuRemainingChargingTime() {
        return ivuRemainingChargingTime;
    }

    public void setIvuRemainingChargingTime(Double ivuRemainingChargingTime) {
        this.ivuRemainingChargingTime = ivuRemainingChargingTime;
    }

    public Integer getSoc() {
        return soc;
    }

    public void setSoc(Integer soc) {
        this.soc = soc;
    }

    public Double getIvuTempCoil1() {
        return ivuTempCoil1;
    }

    public void setIvuTempCoil1(Double ivuTempCoil1) {
        this.ivuTempCoil1 = ivuTempCoil1;
    }

    public Double getIvuTempCoil2() {
        return ivuTempCoil2;
    }

    public void setIvuTempCoil2(Double ivuTempCoil2) {
        this.ivuTempCoil2 = ivuTempCoil2;
    }

    public Double getIvuTempIgbt1() {
        return ivuTempIgbt1;
    }

    public void setIvuTempIgbt1(Double ivuTempIgbt1) {
        this.ivuTempIgbt1 = ivuTempIgbt1;
    }

    public Double getIvuTempIgbt2() {
        return ivuTempIgbt2;
    }

    public void setIvuTempIgbt2(Double ivuTempIgbt2) {
        this.ivuTempIgbt2 = ivuTempIgbt2;
    }
}