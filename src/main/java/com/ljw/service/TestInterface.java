package com.ljw.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.ljw.util.HttpClientUtil;

import com.ljw.util.HttpSender;
import com.ljw.vo.Film;


/**
 * 
 * 
 * 如果有远程接口，可以使用这个进行解析测试
 * 
 * @author PC
 *
 */
@Component
public class TestInterface implements Runnable{
	
	
	@Override
	public void run() {
		this.getResultMap();
	}
	
	public static void main(String[] args) {
		TestInterface t1 = new TestInterface();
//		for (int i = 0; i < 6; i++) {
//			Thread r1 = new Thread(t1,"ljw-"+i);
//			r1.start();
//		}
//		Thread r1 = new Thread(t1,"ljw-");
//		r1.start();
		t1.getResultMap();
		
	}
	
	
	
	public Map<String, Object> getResultMap(){
		
		
		
//--------------------------------请求url---------------------------------------------------------------			
		
		//url
		//String url= "http://localhost:17543/sleep/test1";
		String url= "http://www.baidu.com";
		
		
//--------------------------------请求头信息---------------------------------------------------------------			
		//header
		Map<String, String> requestHeaders = new HashMap<String, String>();
		requestHeaders.put("abc", "456");
		//requestHeaders.put("accept-encoding", "gzip, deflate, sdch, br");
	
		
//--------------------------------请求参数---------------------------------------------------------------			
		//参数
		Map<String, Object> paramValue = new HashMap<String, Object>();
		paramValue.put("uname", "qinbo@migu.cn");
		paramValue.put("passwd", "testtest89");
		paramValue.put("date", new Date());
		paramValue.put("cityId", 4708);
		
		
//		paramValue.put("clientIP", "127.0.0.1");
//		paramValue.put("userId", "aaaaaa");
//		
//		Map<String, String> reMap = new HashMap<String, String>();
//		reMap.put("realtimePlay", "1");
//		reMap.put("download", "1");
//		paramValue.put("userStatus", reMap);
//		
//		paramValue.put("netType", "1");
//		paramValue.put("ts", "1400000000");

		
		//发送Content-Type=application/json情况下的post请求
		String jsonBody = JSON.toJSONString(paramValue);
		
//---------------------------------------发送请求---------------------------------------------------------------		
		
		long t1 = System.currentTimeMillis();

		HttpClientUtil httpClientUtil = new HttpClientUtil();
		//String rtnJson = httpClientUtil.httpClientGet(url);

		String rtnJson = HttpSender.httpPost(url, null, jsonBody, requestHeaders);
//		String rtnJson = HttpSender.httpPost(url, null, body, requestHeaders);
//		String rtnJson = HttpOtherUtil.httpGet(url, null);
//		String rtnJson = HttpOtherUtil.httpJsonPost(url, requestHeaders, jsonBody);
//		String rtnJson = HttpOtherUtil.httpNameValuePairPost(url, requestHeaders, paramValue);
		
		long t2 = System.currentTimeMillis();
		
//---------------------------------------请求结果-------------------------------------------
		
		System.out.println("rtnJsonOrg:"+rtnJson);
		System.out.println("cost:"+(t2-t1));

		
		
		List<Film> resultMap = null;
		try {
			
			resultMap = JSON.parseArray(rtnJson, Film.class);
			System.out.println(resultMap);
			return null;
			
//			System.out.println("resultMap:" + resultMap);
//			String result = resultMap.get("result").toString();
//			MiguATokenResult parseObject = JSON.parseObject(result, MiguATokenResult.class);
//			System.out.println(parseObject);
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
//			resultMap = new HashMap<String, Object>();
//			resultMap.put("cost", (t2-t1));
		}
		
		return null;
	}

	
	public String test12(){
		String url = "https://item.taobao.com/item.htm?spm=a230r.1.14.230.74f7f385WBwunU&id=535806460401&ns=1&abbucket=13#detail";
		
		String httpGet = HttpSender.httpGet(url);
		System.out.println(httpGet);
		
		return null;
	}
	
}
