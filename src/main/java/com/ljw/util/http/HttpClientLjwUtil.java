package com.ljw.util.http;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.httpclient.HostConfiguration;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpHost;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.URI;
import org.apache.commons.httpclient.URIException;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HttpClientLjwUtil {

	public static Log log = LogFactory.getLog(HttpClientLjwUtil.class);
	
	
	private static Map<String,HttpClient> clientMap =  new ConcurrentHashMap<String,HttpClient>();
	
	/**
	 * 每个ip最大允许的连接数：150
	 */
	private static int maxHostConnections = 150;
	
	/**
	 * httpClient允许的最大连接数：250
	 */
	private static int maxTotalConnections = 250;
	
	
	
	
	
	public static HttpClient getClient(URI uri) {
		
		String host = "";
		int port = -1;
		try {
			host = uri.getHost();
			port = uri.getPort();
		} catch (URIException e) {
			log.error(" error http uri: " + uri);
		}
		
		HttpClient httpClient = clientMap.get(host + ":" + port);
		
		if(httpClient == null){
			
			MultiThreadedHttpConnectionManager connectionManager = new MultiThreadedHttpConnectionManager();
			HttpConnectionManagerParams params = new HttpConnectionManagerParams();
			params.setDefaultMaxConnectionsPerHost(maxHostConnections);
			params.setMaxTotalConnections(maxTotalConnections);
			params.setConnectionTimeout(1000000);
			params.setSoTimeout(1000000);
			connectionManager.setParams(params);
			
			
			HttpClientParams httpClientParams = new HttpClientParams();
			// 设置httpClient的连接超时，对连接管理器设置的连接超时是无用的
			httpClientParams.setConnectionManagerTimeout(3000); //等价于4.2.3中的CONN_MANAGER_TIMEOUT
			
			httpClient = new HttpClient(httpClientParams,connectionManager);
			
			
			//初始化httpClient的hostConfiguration参数
			HostConfiguration hostConfiguration = new HostConfiguration();
			HttpHost httpHost = new HttpHost(host);
			hostConfiguration.setHost(httpHost);
			httpClient.setHostConfiguration(hostConfiguration);
			
			httpClient.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
			
			clientMap.put(host + ":" + port, httpClient);
		}
		
		return httpClient;
		
	}
	
	
	
}
