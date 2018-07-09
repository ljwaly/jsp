package com.ljw.conf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.ljw.conf.receiver.Receiver;
import com.ljw.conf.receiver.Receiver2;
import com.ljw.exception.sonexception.MyConfException;

import redis.clients.jedis.JedisPoolConfig;

/**
 * redis工作模式配置
 * @author PC
 *
 */

@Configuration
@PropertySource("classpath:redis-conf.properties")
public class RedisConf {

	enum MODE {
		stand_alone, cluster, sentinel
	}
	@Value("${redis.cluster.nodes}")
	private String clusterNodes;
	
	@Value("${redis.mode}")
	private String mode;

	

	@Value("${redis.max-total}")
	private int maxTotal;

	@Value("${redis.max-idle}")
	private int maxIdle;

	@Value("${redis.stand_alone.host-name}")
	private String hostName;

	@Value("${redis.stand_alone.port}")
	private int port;

	@Value("${redis.db_idx}")
	private int database;
	
	@Value("${redis.cache_manager.default-expire-sec}")
	private int defaultExpireSec4CacheManager;

	@Value("${redis.cache.store.signal}")
	private String topic;
	
	@Value("${redis.sentinel.nodes}")
	private String sentinelNodes;

	@Value("${redis.sentinel.master}")
	private String master4Sentinel;
	
	@Bean
	public RedisConnectionFactory connectionFactory() throws Exception {

		MODE _mode = getMode();

		if (_mode == null) {
			throw new MyConfException("redis mode is null,allowed value is stand_alone, cluster, sentinel");

		}

		switch (_mode) {
		case stand_alone:
			return buildFactoryIsStandAlone();
			
		case cluster:
			return buildFactoryIsCluster();
			
		case sentinel:
			return buildFactoryIsSentinel();

		default:
			throw new Exception("RedisConnectionFactory build exception");
		}

	}
	
	
/**
 * ==================================================================================================================
 * 
 */
	 
	/**
	 * 创建redis数据库接口，RedisTemplate<String,?>的bean对象就是数据库的接口，
	 * （StringRedisTemplate是相当于存储key为String, value也为String的特殊的接口）
	 * 
	 * 
	 * 可以用RedisTemplate的对象存储有String为key的各种对象
	 * 
	 * 
	 * 
	 * 此项目中使用了
	 * （1）RedisTemplate对象接口的存储数据，
	 * （2）StringRedisTemplate对象接口的消息发布模式
	 * 
	 * 
	 */
	
	
	/**
	 * 获取redis模板
	 * @param connectionFactory
	 * @return
	 */
	@Bean
	@Primary
	public 	RedisTemplate<String,?> template(RedisConnectionFactory connectionFactory){
		RedisTemplate<String,?> template =new RedisTemplate<>();
		template.setConnectionFactory(connectionFactory);
		template.setKeySerializer(new StringRedisSerializer());
		
		return template;
	}
	
	
	
/**
 * =================================================================================================================
 * /





	
	
	/**
	 * 
	 * 创建缓存管理器
	 * 
	 * @param redisTemplate
	 * @return
	 */
	@Bean(name="redisCacheManager")
	@Primary//有主次之分，这个可以算是主bean（只能有一个），其他都是次bean（可以有多个）
	public CacheManager cacheManager(RedisTemplate<String,?> redisTemplate){
		
		RedisCacheManager manager = new RedisCacheManager(redisTemplate);
		manager.setDefaultExpiration(this.getDefaultExpireSec4CacheManager());
		return manager;
	}
	
	
	@Bean(name="redisMediaCacheManager")
	public CacheManager mediaAdapterManager(RedisTemplate<String,?> redisTemplate){
		
		RedisCacheManager manager=new RedisCacheManager(redisTemplate);
		manager.setDefaultExpiration(this.getDefaultExpireSec4CacheManager());	
		return manager;
	}
	
	
	
	/**
	 * 创建委托方法
	 * @param receiver
	 * @return
	 */
	@Bean("listenerAdapter1")
	@Primary
	MessageListenerAdapter listenerAdapter1(Receiver  receiver) {
		
		return new MessageListenerAdapter(receiver, "receiveMessage");//引用委托，将方法receiveMessage引用封装在委托receiver对象内
	}
	
	@Bean("listenerAdapter2")
	MessageListenerAdapter listenerAdapter(Receiver2 receiver2) {
		
		return new MessageListenerAdapter(receiver2, "receiveMessage");//引用委托，将方法receiveMessage引用封装在委托receiver对象内
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//--------------------------------------------------------------------------------------------------------------------------------	
	
	/**
	 * stand_alone模式
	 * @return
	 */
	private RedisConnectionFactory buildFactoryIsStandAlone() {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(maxTotal);
		config.setMaxIdle(maxIdle);
		
		JedisConnectionFactory factory = new JedisConnectionFactory(config);
		factory.setHostName(hostName);
		factory.setPort(port);
		factory.setUsePool(true);
		factory.setDatabase(database);
		factory.afterPropertiesSet();
		
		return factory;
	}
	
	/**
	 * Cluster集群模式
	 * @return
	 */
	private RedisConnectionFactory buildFactoryIsCluster() {
		JedisPoolConfig config =new JedisPoolConfig();
		config.setMaxTotal(maxTotal);
		config.setMaxIdle(maxIdle);
		
		List<String> clusterList = new ArrayList<>();
		if (clusterNodes.startsWith("[")) {
			String clusters = clusterNodes.substring(1, clusterNodes.length()-1);
			String[] split = clusters.split(",");
			for (String cluster : split) {
				clusterList.add(cluster);
			}
		}
		RedisClusterConfiguration clusterConf = new RedisClusterConfiguration(clusterList);
		JedisConnectionFactory factory = new JedisConnectionFactory(clusterConf); 
		factory.setUsePool(true);
		factory.setDatabase(database);
		factory.setPoolConfig(config);
		//factory.setPassword("football");
		//factory.setHostName("11");
		return factory;
	}
	
	/**
	 * Sentinel监听模式
	 * @return
	 */
	private RedisConnectionFactory buildFactoryIsSentinel() {
		RedisSentinelConfiguration sentinelConfig = new RedisSentinelConfiguration().master(master4Sentinel);
		String host;
		int port;
		
		List<String> sentinelList = new ArrayList<>();
		if (sentinelNodes.startsWith("[")) {
			String sentinels = sentinelNodes.substring(1, clusterNodes.length()-1);
			if (sentinels.indexOf(",") != -1) {
				String[] split = sentinels.split(",");
				for (String sentinel : split) {
					sentinelList.add(sentinel);
				}
			}
		}
		
		for(String sentinelNode : sentinelList){
			host = sentinelNode.split(":")[0];
			port = Integer.parseInt(sentinelNode.split(":")[1]);
			sentinelConfig.addSentinel(new RedisNode(host, port));
		}
		
		JedisPoolConfig config =new JedisPoolConfig();
		config.setMaxTotal(maxTotal);
		config.setMaxIdle(maxIdle);
		
		JedisConnectionFactory factory = new JedisConnectionFactory(sentinelConfig);
		factory.setPoolConfig(config);
		factory.setUsePool(true);
		factory.setDatabase(database);
		
		return factory;
	}
	
	private long getDefaultExpireSec4CacheManager() {
		return defaultExpireSec4CacheManager;
	}


	private MODE getMode() {

		return MODE.valueOf(mode);
	}

}
