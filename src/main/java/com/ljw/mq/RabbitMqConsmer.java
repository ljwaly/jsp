package com.ljw.mq;

import java.io.IOException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;


/**
 * 封装mq消息处理的接口
 * 
 * @author PC
 *
 */
public class RabbitMqConsmer extends DefaultConsumer{

	private IEventHandler handler;
	
	public RabbitMqConsmer(Channel channel, IEventHandler handler) {
		super(channel);
		this.handler = handler;
	}

	
	@Override
	public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
			byte[] body) throws IOException {
		
		String message = new String(body, "UTF-8");
		handler.onEventReceived(message);
	}
}
