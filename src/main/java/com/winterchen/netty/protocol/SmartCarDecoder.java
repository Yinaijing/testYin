package com.winterchen.netty.protocol;

import com.winterchen.Springboot2MybatisDemoApplication;
import com.winterchen.model.data;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.util.List;

/**
 * @author miao
 */
public class SmartCarDecoder extends ByteToMessageDecoder {


    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf buffer, List<Object> out) {

        Channel channel = channelHandlerContext.channel();
        int length = buffer.readableBytes();
        byte[] array = new byte[length];
        buffer.getBytes(buffer.readerIndex(), array);

        DataProcessor dataProcessor = new DataProcessor(channel, array);
        dataProcessor.onRead();
        byte[] package1 = dataProcessor.getPackage();

        // 通过ApplicationContext去拿取需要的实体
        Transmitter transmitter = Springboot2MybatisDemoApplication.getBean(Transmitter.class);

        data dataObject = transmitter.onPackageReceived(package1);
        //要截取一下字符串的长度
        dataObject.setIp(channel.remoteAddress().toString());
        out.add(dataObject);
    }
}
