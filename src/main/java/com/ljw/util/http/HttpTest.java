package com.ljw.util.http;

public class HttpTest {

	public static void main(String[] args) {
		
		String url = "http://221.181.100.151:8082/clt30/echo.jsp";
		HttpRequestUtil httpRequestUtil = new HttpRequestUtil();
		String rtnJsn = httpRequestUtil.httpClientPost(url, null);
		System.out.println(rtnJsn);
	}
}
