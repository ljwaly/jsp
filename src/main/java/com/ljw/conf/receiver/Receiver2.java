package com.ljw.conf.receiver;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.ljw.core.domain.RedisMessageRecord;
import com.ljw.util.DateLjwUtil;





/**
 * redis接收消息处理
 * @author ljw
 *
 */
@Component
public class Receiver2{
	

	
	@Autowired
	private RedisTemplate<String, List<RedisMessageRecord>> redisTemplate;
	
	public String receiveMessage(String message) {
		
		
		System.out.println("receiver2="+message);
		
	
		return message;	
	}
}
