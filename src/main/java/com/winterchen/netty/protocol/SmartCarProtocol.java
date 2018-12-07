package com.winterchen.netty.protocol;

import java.util.Arrays;

public class SmartCarProtocol {
    /**
     * 消息的开头的信息标志
     */
    private int head_data;
    /**
     * 消息的长度
     */
    private int contentLength;
    /**
     * 消息的内容
     */
    private byte[] content;

    /**
     * 用于初始化，SmartCarProtocol
     *
     * @param contentLength
     *            协议里面，消息数据的长度
     * @param content
     *            协议里面，消息的数据
     */
    public SmartCarProtocol(int contentLength, byte[] content) {
        this.contentLength = contentLength;
        this.content = content;
    }

    /**
     * 用于初始化，SmartCarProtocol
     * @param head_data
     *              消息头
     * @param contentLength
     *              消息数据的长度
     * @param content
     *              消息数据内容
     */
    public SmartCarProtocol(int head_data, int contentLength, byte[] content) {
        this.head_data = head_data;
        this.contentLength = contentLength;
        this.content = content;
    }

    public void setHead_data(int head_data) {
        this.head_data = head_data;
    }

    public int getHead_data() {
        return head_data;
    }

    public int getContentLength() {
        return contentLength;
    }

    public void setContentLength(int contentLength) {
        this.contentLength = contentLength;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "SmartCarProtocol [head_data=" + head_data + ", contentLength="
                + contentLength + ", content=" + Arrays.toString(content) + "]";
    }
}
