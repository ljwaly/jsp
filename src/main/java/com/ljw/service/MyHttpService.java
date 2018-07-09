package com.ljw.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.ljw.util.HttpClientUtil;

@Service
public class MyHttpService {
	
	
	/**
	 * get请求
	 * 
	 * @param url
	 * @param header
	 * @param requestParamsMap
	 * @return
	 */
	public String getHttpString(String url, Map<String, String> header){
		
		String rtnJson = HttpClientUtil.httpClientGet(url, header);
		
		
		
		return rtnJson;
		
	}
}
