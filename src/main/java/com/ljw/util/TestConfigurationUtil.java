package com.ljw.util;

import com.ljw.cache.CacheManager;

public class TestConfigurationUtil {
	
	
	public static String getName(String key){
		return CacheManager.conf.getProperty(key);
		
	}
	
}
