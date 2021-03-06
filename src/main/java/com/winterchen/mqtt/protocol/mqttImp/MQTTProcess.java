package com.winterchen.mqtt.protocol.mqttImp;

import com.winterchen.mqtt.util.MqttTool;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.IdleStateHandler;

import com.winterchen.mqtt.protocol.mqttImp.message.ConnectMessage;
import com.winterchen.mqtt.protocol.mqttImp.message.Message;
import com.winterchen.mqtt.protocol.mqttImp.message.PackageIdVariableHeader;
import com.winterchen.mqtt.protocol.mqttImp.message.PublishMessage;
import com.winterchen.mqtt.protocol.mqttImp.message.SubscribeMessage;
import com.winterchen.mqtt.protocol.mqttImp.message.UnSubscribeMessage;
import com.winterchen.mqtt.protocol.mqttImp.process.ProtocolProcess;
import org.apache.log4j.Logger;


/**
 *  MQTT协议业务处理
 * 
 * @author zer0
 * @version 1.0
 * @date 2015-2-16
 */
@ChannelHandler.Sharable
public class MQTTProcess extends ChannelHandlerAdapter {
	private final static Logger logger = Logger.getLogger(MQTTProcess.class);
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		ProtocolProcess process = ProtocolProcess.getInstance();
		Message message = (Message)msg;
		switch (message.getFixedHeader().getMessageType()) {
		case CONNECT:
			process.processConnect(ctx.channel(), (ConnectMessage)message);
			break;
		case CONNACK:
			break;
		case PUBLISH:
			process.processPublic(ctx.channel(), (PublishMessage)message);
			break;
		case PUBACK:
			process.processPubAck(ctx.channel(), (PackageIdVariableHeader)message.getVariableHeader());
			break;
		case PUBREL:
			process.processPubRel(ctx.channel(), (PackageIdVariableHeader)message.getVariableHeader());
			break;
		case PUBREC:
			process.processPubRec(ctx.channel(), (PackageIdVariableHeader)message.getVariableHeader());
			break;
		case PUBCOMP:
			process.processPubComp(ctx.channel(), (PackageIdVariableHeader)message.getVariableHeader());
			break;
		case SUBSCRIBE:
			process.processSubscribe(ctx.channel(), (SubscribeMessage)message);
			break;
		case SUBACK:
			break;
		case UNSUBSCRIBE:
			process.processUnSubscribe(ctx.channel(), (UnSubscribeMessage)message);
			break;
		case UNSUBACK:
			break;
		case PINGREQ:
			process.processPingReq(ctx.channel(), message);
			break;
		case DISCONNECT:
			process.processDisconnet(ctx.channel(), message);
			break;

		default:
			break;
		}
	}
	
	/**
   	 * 事件追踪，处理超时事件，一旦检测到读超时，就断开链接
   	 * @param ctx
   	 * @param evt 
   	 * @author zer0
   	 * @version 1.0
   	 * @date 2016-3-7
   	 */
	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt)
			throws Exception {
		if (evt instanceof IdleStateEvent) {
			IdleStateEvent e = (IdleStateEvent)evt;
			if (e.state() == IdleState.READER_IDLE) {
				ctx.close();
			}else {
				//写超时不处理
			}
		}
	}
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.log(org.apache.log4j.Level.WARN,"Unexpected exception from downstream.", cause);
        ctx.close();
    }


}
