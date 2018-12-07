package com.winterchen.netty.protocol;

import org.springframework.stereotype.Component;
import java.util.Date;

@lombok.Data
public class Data {
    public Date timestamp;
    public String ip;
    public String iapState;
    public int type;
    public int operatingState;
    public int stationState;
    public Double inputVolt;
    public Double inputCurr;
    public Double outputVolt;
    public Double outputCurr;
    public Double coilCurr;
    public Double inverterTemp;
    public Double outputPower;
    public Double batMaxVolt;
    public Double batMaxCurr;
    public Double remainingChargingTime;
    public String version;
    public int dcdcState;
    public Double dcdcReferenceVolt;
    public Double dcdcOutputVolt;
    public Double dcdcOutputCurr;
    public int dcacState;
    public Double dcacInputVolt;
    public Double dcacInputCurr;
    public Double dcacReferencePower;
    public Double dcacOutputPower;
    public Double dcacTempIgbt1;
    public Double dcacTempIgbt2;
    public Double dcacTempResonantInductor;
    public Double dcacTempTransformer;
    public Double dcacInsulationResistance;
    public Double dcacTempCoil;
    public int ivuState;
    public Double ivuRelayVolt;
    public Double ivuBatChargingVolt;
    public Double ivuBatChargingCurr;
    public Double ivuBatMaxVolt;
    public Double ivuBatMaxCurr;
    public Double ivuChargedEnergy;
    public Double ivuRemainingChargingTime;
    public int soc;
    public Double ivuTempCoil1;
    public Double ivuTempCoil2;
    public Double ivuTempIgbt1;
    public Double ivuTempIgbt2;

    public Data() {
    }

    protected boolean canEqual(Object other) {
        return other instanceof Data;
    }

}
