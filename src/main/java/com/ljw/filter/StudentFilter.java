package com.ljw.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


/**
 * 
 * 某一个过滤器
 * @author ljw
 *
 */
public class StudentFilter implements Filter{

	//private static final String[] RESERVED_INIT_PARAMS ={"renew", "abc", "def","name"};
	private String name;
	private String type;
	private String url;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 启动服务Server，此方法自动执行
	 * 如果需要某些操作可以在这里执行
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
//		int a=10;
//		System.out.println(a);
		
	}

	/**
	 * 有匹配此过滤器的请求（StudentFilter的bean的内部的urlPatterns的链接）出现后，会执行此方法
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		String serverName = request.getServerName();
		int serverPort = request.getServerPort();
		System.out.println("request:serverName="+serverName);
		System.out.println("request:serverPort="+serverPort);
		System.out.println("StudentFilter:[name="+name+",type="+type+",url="+url+"]");
		
		chain.doFilter(request, response);//可以让访问继续进行下去
	}

	@Override
	public void destroy() {
		int c=1000;
		System.out.println(c);
	}

	

}
