package com.ljw.cache;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ljw.util.Configuration;


/**
 * 模拟缓存
 * @author PC
 *
 */
@Component
@PropertySource(value="classpath:redis-conf.properties",encoding="utf-8")
public class CacheManager {
	
	private Logger logger = LoggerFactory.getLogger(CacheManager.class);
	private static final Map<Long,String> testMap = new  HashMap<Long,String>();

	public static Configuration conf;
	
	
	@Value("${spring_name}")
	private String name;
	
//	定时操作
	//@Scheduled(fixedRate = 1000*5)
//	@Scheduled(cron="0/1 * * * * ?")
//	public void executeInternal(){
//		System.out.println(new Date()+":111");
//	}
	
	
	@PostConstruct
	public void init(){
		
		System.out.println("ljw="+name);
		
		for (Long i = 0L; i < 100L; i++) {
			
			testMap.put(i, "shao"+i);
		}
		conf = Configuration.getInstance();
		
		logger.info("testManager finished!");
	}
	
	
	public String getTestmap(Long index) {
		return testMap.get(index);
	}
	
	/**
	 * map遍历
	 */
	public void printMap(){
		testMap.forEach(new MyMapAction());
	}
	
	public static void main(String[] args) {
		CacheManager c = new CacheManager();
		c.init();
		c.printMap();
		
	}
	
}	


class MyMapAction implements BiConsumer<Long,String>{

	@Override
	public void accept(Long t, String u) {
		System.out.println("key=" + t + ", value=" + u);
		
	}
	
}



