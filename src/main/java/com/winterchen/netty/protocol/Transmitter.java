package com.winterchen.netty.protocol;

import java.util.*;

import com.winterchen.model.data;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/***
 * @author miaojinlong
 * @created 2018-11-09
 */

public class Transmitter {
    @Autowired
    private data dataObject;

    private final static Logger logger = Logger.getLogger(Transmitter.class);
    public boolean inverterIsOnline,inverterRunning, overCurr, overTemp;
    public boolean inverterFault, inverterWarning;
    public boolean carDetected;
    public boolean inBootLoader;
    public boolean updating;
    public boolean iapFailed;
    public boolean otherError ;
    public int majorVersion, minorVersion;
    public int transmitterType;
    public Date lastUpdateTime;
    public List<byte[]> lastPackets = new ArrayList<>();

    public Transmitter() {
        lastUpdateTime = new Date();
    }

    public data onPackageReceived(byte[] package1) {
        List<byte[]> packets = decodePackage(package1);
        lastPackets = packets;
        for (byte[] p : packets) {
            switch (p[0]) {
                case 0x08:
                    if ((p[1] & 0x01) != 0) {
                        inBootLoader = true;
                    }
                    if ((p[1] & 0x02) != 0) {
                        updating = true;
                    }
                    if ((p[1] & 0x04) != 0) {
                        iapFailed = true;
                    }
                    break;
                case 0x0F:
                    dataObject.setType((int) p[1]);
                    transmitterType = (int) p[1];
                    break;
                case 0x10:
                    getRunState(p);
                    break;
                case 0x11:
                    dataObject.setStationState((int) p[1]);
                    break;
                case 0x20:
                    dataObject.setInputVolt(GenerateData(p, 0.1, 1, 2));
                    break;
                case 0x21:
                    dataObject.setInputCurr(GenerateData(p, 0.01, 1, 2));
                    break;
                case 0x22:
                    dataObject.setOutputVolt(GenerateData(p, 0.1, 1, 2));
                    break;
                case 0x23:
                    dataObject.setOutputCurr(GenerateData(p, 0.01, 1, 2));
                    break;
                case 0x24:
                    dataObject.setCoilCurr(GenerateData(p, 0.01, 1, 2));
                    break;
                case 0x25:
                    dataObject.setInverterTemp(GenerateData(p, 0.1, 1, 2));
                    break;
                case 0x26:
                    dataObject.setOutputPower(GenerateData(p, 1, 1, 2));
                    break;
                case 0x27:
                    dataObject.setBatMaxVolt(GenerateData(p, 0.1, 1, 2));
                    break;
                case 0x28:
                    dataObject.setBatMaxCurr(GenerateData(p, 0.01, 1, 2));
                    break;
                case 0x29:
                    dataObject.setRemainingChargingTime(GenerateData(p, 1, 1, 2));
                    break;
                case 0x2F: getVersion(p);
                    break;
                case (byte) 0xA0: getDcdcInfo(p);
                    break;
                case (byte) 0xA1: getDcacInfo1(p);
                    break;
                case (byte) 0xA2: getDcacInfo2(p);
                    break;
                case (byte) 0xA3: getIvuInfo1(p);
                    break;
                case (byte) 0xA4: getIvuInfo2(p);
                    break;
                case (byte) 0xA5: getIvuInfo3(p);
                    break;
                default:
                    break;
            }
        }
        dataObject.setTimestamp(new Date());
        return dataObject;
    }

    static double GenerateData(byte[] buf, double unit, int begin, int len) {
        int ret = 0;
        for (int i = 0; i < len; ++i) {
            ret = ret * 256 + buf[i + begin];
        }
        return ret * unit;
    }

    private static List<byte[]> decodePackage(byte[] package1) {
        List<byte[]> ret = new ArrayList<>();
        int now = 0;
        while (now < package1.length) {
            int packet_id = package1[now] & 0xff;
            int packet_len = 0;
            if (packet_id < 32) {
                packet_len = 1 + (packet_len - 0) / 32;
            } else if (packet_id < 128) {
                packet_len = 2 + (packet_id - 32) / 16;
            } else if ( packet_id < 224) {
                packet_len = 8 + (packet_id  - 128) / 8;
            } else {
                packet_len = 20 + (packet_id - 224) / 4;
            }
            if (packet_len + now + 1 > package1.length) {
                logger.error("Invalid package1");
                logger.error(package1.toString());
                return new ArrayList<>();
            } else {
                byte[] packet = new byte[1 + packet_len];
                System.arraycopy(package1, now, packet, 0, 1 + packet_len);
                ret.add(packet);
                now += 1 + packet_len;
            }
        }
        return ret;
    }

    private void getRunState(byte[] p) {
        byte status = p[1];
        inverterIsOnline = (status & (1 << 0)) == 0;
        inverterRunning = (status & (1 << 1)) != 0;
        overCurr = (status & (1 << 2)) != 0;
        overTemp = (status & (1 << 3)) != 0;
        inverterWarning = (status & (1 << 4)) != 0;
        inverterFault = (status & (1 << 5)) != 0;
        carDetected = (status & (1 << 6)) != 0;
        otherError = (status & (1 << 7)) != 0;
        dataObject.setOperatingState((int) p[1]);
    }

    private void getVersion(byte[] p) {
        majorVersion = p[1];
        minorVersion = p[2] & 0xff;
        dataObject.setVersion(p[1] + "." + minorVersion);
    }

    private void getDcdcInfo(byte[] p) {
        dataObject.setDcdcState((int) p[1] & 0xff * 256 + (int) p[2]);
        dataObject.setDcdcReferenceVolt(GenerateData(p, 0.1, 3, 2));
        dataObject.setDcdcOutputCurr(GenerateData(p, 0.1, 5, 2));
        dataObject.setDcdcOutputCurr(GenerateData(p, 0.01, 7, 2));
    }

    private void getDcacInfo1(byte[] p) {
        dataObject.setDcacState((int) p[1] & 0xff * 256 + (int) p[2]);
        dataObject.setDcacInputVolt(GenerateData(p, 0.1, 3, 2));
        dataObject.setDcacInputCurr(GenerateData(p, 0.01, 5, 2));
        dataObject.setDcacReferencePower(GenerateData(p, 1, 7, 2));
        dataObject.setDcacOutputPower(GenerateData(p, 1, 9, 2));
    }

    private void getDcacInfo2(byte[] p) {
        dataObject.setDcacTempIgbt1(GenerateData(p, 0.1, 1, 2));
        dataObject.setDcacTempIgbt2(GenerateData(p, 0.1, 3, 2));
        dataObject.setDcacTempResonantInductor(GenerateData(p, 0.1, 5, 2));
        dataObject.setDcacTempTransformer(GenerateData(p, 0.1, 7, 2));
        dataObject.setDcacInsulationResistance(GenerateData(p, 0.1, 9, 2));
        dataObject.setDcacTempCoil(GenerateData(p, 0.1, 11, 2));
    }

    private void getIvuInfo1(byte[] p) {
        dataObject.setIvuState((int) p[1] & 0xff * 256 + (int) p[2]);
        dataObject.setIvuRelayVolt(GenerateData(p, 0.1, 3, 2));
        dataObject.setIvuBatChargingVolt(GenerateData(p, 0.1, 5, 2));
        dataObject.setIvuBatChargingCurr(GenerateData(p, 0.01, 7, 2));
    }

    private void getIvuInfo2(byte[] p) {
        dataObject.setIvuBatMaxVolt(GenerateData(p, 0.1, 1, 2));
        dataObject.setIvuBatMaxCurr(GenerateData(p, 0.01, 3, 2));
        dataObject.setIvuChargedEnergy(GenerateData(p, 0.1, 5, 2));
        dataObject.setIvuRemainingChargingTime(GenerateData(p, 1, 7, 2));
        dataObject.setSoc(p[8]&0xff);
    }

    private void getIvuInfo3(byte[] p) {
        dataObject.setIvuTempCoil1( GenerateData(p, 0.1, 1, 2));
        dataObject.setIvuTempCoil2( GenerateData(p, 0.1, 3, 2));
        dataObject.setIvuTempIgbt1(GenerateData(p, 0.1, 5, 2));
        dataObject.setIvuTempIgbt2(GenerateData(p, 0.1, 7, 2));
    }
}
