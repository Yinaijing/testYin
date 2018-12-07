package com.winterchen.netty.protocol;

import io.netty.channel.*;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;


public class ChannelHandler extends SimpleChannelInboundHandler {


    private static final ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.forEach(ch -> {
            if (ch != channel){
                ch.writeAndFlush(channel.remoteAddress() + " 发送的消息：" + msg + "\n");
            }else{
                ch.writeAndFlush("【自己】" + msg + "\n");
            }
        });
    }

    @Override
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.channel().close();
    }

    // 通道建立事件
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("服务器 - " + channel.remoteAddress() + "加入\n");
        channelGroup.add(channel);
    }

    // 通道活跃事件
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println(channel.remoteAddress() + "上线了");
    }

    // 通道不活跃事件
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println(channel.remoteAddress() + "下线了");
    }

    // 通道被移除事件
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("服务器 - " + channel.remoteAddress() + "离开\n");
        // 移出(netty会自动执行，不写也行)
        channelGroup.remove(channel);
        System.out.println(channelGroup.size());
    }

}
