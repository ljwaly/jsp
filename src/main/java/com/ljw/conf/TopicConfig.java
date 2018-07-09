package com.ljw.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Component;


@Component
public class TopicConfig {

	@Autowired
	@Qualifier("listenerAdapter1")
	private MessageListenerAdapter listenerAdapter1;
	
	@Autowired
	@Qualifier("listenerAdapter2")
	private MessageListenerAdapter listenerAdapter2;
	
	
	/**
	 * 
	 * 创建发布/接收模式的监听容器
	 * 
	 * @param connectionFactory
	 * @param listenerAdapter
	 * @return
	 */
	@Bean
	RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory){
	
		RedisMessageListenerContainer container = new RedisMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		
		container.addMessageListener(listenerAdapter1, new ChannelTopic("topic1"));//必须要用ChannelTopic这个类，不能用其父类的另一个子类PatternTopic
		container.addMessageListener(listenerAdapter2, new ChannelTopic("topic2"));//必须要用ChannelTopic这个类，不能用其父类的另一个子类PatternTopic
		
		return container;
	}
	
	
	
	
}
