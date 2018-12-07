package com.winterchen.netty.protocol;

import io.netty.channel.Channel;
import org.apache.log4j.Logger;

/**
 * @author miaojinlong
 * @create 2018-11-09-15:05
 */

public class DataProcessor {
    private final static Logger logger = Logger.getLogger(DataProcessor.class);
    private Channel channel;
    private byte[] message;
    private byte[] buf = new byte[4096];
    private int pos;
    public boolean disconnected;
    private byte[] package1 = null;

    public DataProcessor(Channel channel, byte[] message) {
        this.channel = channel;
        this.message = message;
    }

    public void onRead(){
        try {
            int len = message.length;
            if (len == 0) {
                channel.close();
                disconnected = true;
            } else {
                pos += len;
                processData();
            }
        } catch (Exception e) {
            logger.error(e.toString());
            channel.close();

            disconnected = true;
        }
    }

    public void processData() {
        if (pos >= buf.length * 0.75) {
            onInvalidData(buf, 0, buf.length / 2);
            byte[] newBuf = new byte[buf.length];
            System.arraycopy(buf, buf.length / 2, newBuf, 0, pos - buf.length / 2);
            pos = pos - buf.length / 2;
            buf = newBuf;
        }
        boolean packageFound;
        buf = message;
        do {
            packageFound = false;
            for (int i = 0; i < pos - 4; ++i) {
                if((buf[i] == (byte) 0xA5) && (buf[i + 1] == (byte) 0xA5)) {
                    int len = (buf[i + 2] & 0xff) * 256 + buf[i + 3] & 0xff;
                    if (len + i + 5 > pos) {
                        continue;
                    }
                    if (CRC8Util.calcCrc8(buf, i, len + i + 4) != buf[i + 4 + len]) {
                        continue;
                    }
                    if (i > 0) {
                        onInvalidData(buf, 0, i - 1);
                    }
                    package1 = new byte[len];
                    System.arraycopy(buf, i + 4, package1, 0, len);
                    byte[] newBuf = new byte[buf.length];
                    System.arraycopy(buf, i + len + 5, newBuf, 0, pos - (i + len + 5));
                    buf = newBuf;
                    pos = pos - (i + len + 5);
                    packageFound = true;
                    break;
                } else {
                    continue;
                }
            }
        } while (packageFound);
    }

    public byte[] getPackage() {
        byte[] tmp = package1;
        package1 = null;
        return tmp;
    }

    private void onInvalidData(byte[] buf, int start, int stop) {
        byte[] data = new byte[stop - start];
        System.arraycopy(buf, start, data, 0, stop - start);
        logger.error("Invalid data:" + data.toString());
    }
}