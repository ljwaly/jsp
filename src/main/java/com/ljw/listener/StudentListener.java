package com.ljw.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


/**
 * 监听器，可以写一些需要初始化的内容
 * @author PC
 *
 */
public class StudentListener implements ServletContextListener{

	
	/**
	 * 监听方法，可以写一些，需要初始化的静态参数
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();
		String realPath = context.getRealPath("/");
		System.out.println(realPath);
		
		
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

}
