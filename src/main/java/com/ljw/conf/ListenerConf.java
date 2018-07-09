package com.ljw.conf;

import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ljw.listener.StudentListener;


/**
 * 监听器支持
 * @author ljw
 *
 */
@Configuration
public class ListenerConf {

	@Bean
	public ServletListenerRegistrationBean<StudentListener> setStudentListener(){
		
		ServletListenerRegistrationBean<StudentListener> listenerRegistrationBean  =
				new ServletListenerRegistrationBean<StudentListener>();
		StudentListener listener = new StudentListener();
		listenerRegistrationBean.setListener(listener);
		return listenerRegistrationBean;
		
	}
	
}
