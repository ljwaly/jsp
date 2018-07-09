package com.ljw.mq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.ljw.mq.handler.MqHandlerReceiver;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
/**
 * 这个没问题，只是rabbitMQ的后台出了问题，暂时无法启动
 */
//@Component
public class RabbitMqReceiverConfig {
	private final static String QUEUE_NAME = "hello2";
	
	private final static String Routing_Key = "p.event_hello2";
	
	private final static String Exchange = "ljw123";



	
	@PostConstruct
	public void initConsumer(){
		IEventHandler handler = new MqHandlerReceiver();
		connect(handler);
	}
	

	private void connect(IEventHandler handler){
		try {
			// 创建连接工厂
			ConnectionFactory factory = new ConnectionFactory();
			// 设置RabbitMQ地址
			factory.setHost("localhost");
			factory.setUsername("ljwly");
			factory.setPassword("1988ljw");
			//factory.setPort(2088);
			// 创建一个新的连接
			Connection connection = factory.newConnection();
			// 创建一个通道
			Channel channel = connection.createChannel();
			
			// 声明要关注的队列
			channel.queueDeclare(QUEUE_NAME, false, false, false, null);
			channel.queueBind(QUEUE_NAME, Exchange, Routing_Key);
			
			System.out.println("Customer Waiting Received messages");
			
			Consumer consumer = new RabbitMqConsmer(channel, handler);
			
			// 自动回复队列应答 -- RabbitMQ中的消息确认机制
			channel.basicConsume(QUEUE_NAME, true, consumer);
			
		} catch (IOException | TimeoutException e) {
			
			e.printStackTrace();
		}
	}

	
//	@PostConstruct
//	public void init() {
//		try {
//			// 创建连接工厂
//			ConnectionFactory factory = new ConnectionFactory();
//			// 设置RabbitMQ地址
//			factory.setHost("localhost");
//			factory.setUsername("ljwly");
//			factory.setPassword("1988ljw");
//			//factory.setPort(2088);
//			// 创建一个新的连接
//			Connection connection = factory.newConnection();
//			// 创建一个通道
//			Channel channel = connection.createChannel();
//			
//			// 声明要关注的队列
//			channel.queueDeclare(QUEUE_NAME, false, false, false, null);
//			channel.queueBind(QUEUE_NAME, Exchange, Routing_Key);
//			
//			System.out.println("Customer Waiting Received messages");
//			
//			// DefaultConsumer类实现了Consumer接口，通过传入一个频道，
//			// 告诉服务器我们需要那个频道的消息，如果频道中有消息，就会执行回调函数handleDelivery
//			Consumer consumer = new DefaultConsumer(channel) {
//				@Override
//				public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
//						byte[] body) throws IOException {
//					String message = new String(body, "UTF-8");
//					System.out.println("Customer Received '" + message + "'");
//				}
//			};
//			// 自动回复队列应答 -- RabbitMQ中的消息确认机制
//			channel.basicConsume(QUEUE_NAME, true, consumer);
//		} catch (IOException | TimeoutException e) {
//			
//			e.printStackTrace();
//		}
//	}
}
