package com.winterchen.netty.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class SmartCarEncoder extends MessageToByteEncoder<SmartCarProtocol> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, SmartCarProtocol smartCarProtocol, ByteBuf byteBuf) throws Exception {
        // 写入消息SmartCar的具体内容
        // 1.写入消息的开头的信息标志(int类型)
        byteBuf.writeInt(smartCarProtocol.getHead_data());
        // 2.写入消息的长度(int 类型)
        byteBuf.writeInt(smartCarProtocol.getContentLength());
        // 3.写入消息的内容(byte[]类型)
        byteBuf.writeBytes(smartCarProtocol.getContent());
    }
}
