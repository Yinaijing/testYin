package com.winterchen.netty.protocol;

import com.winterchen.model.data;
import com.winterchen.service.user.dataService;
import com.winterchen.service.user.impl.dataServiceImpl;
import com.winterchen.util.SpringUtil;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import java.util.ArrayList;
import java.util.List;

public class ServerHandler extends ChannelHandlerAdapter {

    private static dataService dataService = SpringUtil.getBean(dataServiceImpl.class);
    private static int n = 0;
    private static List<data> list = new ArrayList<>();

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        data dataObject = (data)msg;
        dataService.insert(dataObject);

        /*n=n+1;
        list.add(dataObject);
        if (n==5) {
            dataService.insertList(list);
            list.clear();
            n=0;
        }*/
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        ctx.close();
    }
}





