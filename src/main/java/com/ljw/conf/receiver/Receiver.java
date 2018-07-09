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
public class Receiver{
	
	private static final String KEY_STORE = "KeyStore";
	
	private static final String KEY_BODY = "body";
	
	@Autowired
	private RedisTemplate<String, List<RedisMessageRecord>> redisTemplate;
	
	public String receiveMessage(String message) {
		
		
		System.out.println("receiver="+message);
		
		String[] note = message.split("_");//按照管理端publish传入格式进行解析
		String operator=note.length>0?note[0].trim():"";
		
		String body=note.length>1?note[1].trim():"";
		Map<String, Object> contextMap = new HashMap<String, Object>();
		contextMap.put(KEY_BODY, body);
		
		String date=DateLjwUtil.dateToString(new Date());
		
		
		
		//根据key取出记录
		List<RedisMessageRecord> recordList = redisTemplate.opsForValue().get(KEY_STORE);
		
		if (recordList==null) {//无记录,创建新的记录列表
			recordList = new ArrayList<RedisMessageRecord>();
		}
		
		//记录序列化处理
		RedisMessageRecord record =new RedisMessageRecord();
		record.setOperator(operator);
		record.setContext(contextMap);
		record.setDate(date);
		
		//添加新的记录
		recordList.add(record);
		
		//存储记录
		redisTemplate.opsForValue().set(KEY_STORE, recordList, 30L, TimeUnit.SECONDS);//超过30秒，没有操作，记录消失
		
		
	
		return message;	
	}
}
