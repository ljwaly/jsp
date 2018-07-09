package com.ljw.util.http;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.commons.httpclient.HttpMethodBase;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.URI;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 执行http请求
 * @author PC
 *
 */
public class HttpRequestUtil {

	
	public static Log log = LogFactory.getLog(HttpRequestUtil.class);
	
	
	
	/**
	 * 使用post方式调用
	 * 
	 * @param url 调用的URL
	 * @param values 传递的参数值List
	 * @return 调用得到的字符串
	 */
	public String httpClientPost(String url,List<NameValuePair[]> values){
		PostMethod postMethod = new PostMethod(url);
		
		if (values != null) {
			//将表单的值放入postMethod中
			for (NameValuePair[] value : values) {
				postMethod.addParameters(value);
			}
		}
		
		return getResponseStr(postMethod);

	}
	
	
	
	/**
	 * 发送post或get请求获取响应信息
	 * 
	 * @param method	http请求类型,post或get请求
	 * @return			服务器返回的信息
	 */
	private static String getResponseStr(HttpMethodBase method) {
		StringBuilder sb = new StringBuilder();
		URI uri = null;
		try {
			uri = method.getURI();
			
			
			int statusCode = HttpClientLjwUtil.getClient(uri).executeMethod(method);
			if (statusCode != 200) {
				log.error("HttpClient Error, statusCode:" + statusCode + ", uri :" + uri );
				return "";
			}
			//以流的行式读入，避免中文乱码
			InputStream is = method.getResponseBodyAsStream();
			BufferedReader dis = new BufferedReader(new InputStreamReader(is,"utf-8"));   
			String str = "";                           
			while ((str = dis.readLine()) != null) {
				sb.append(str);
			}
		} catch (Exception e) {
			log.error("HttpClient Error, errMsg:" + e.getMessage() + ",uri:" + uri);
		} finally {
			// 关闭连接
			method.releaseConnection();
		}
		return sb.toString();
	}
}
