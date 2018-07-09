package com.ljw.conf;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ljw.filter.StudentFilter;

@Configuration
public class FilterConf {

	
	@Bean("studentFilter")
	public FilterRegistrationBean setStudentFilter(){
		
		FilterRegistrationBean filterRegistration= new FilterRegistrationBean();
		
		StudentFilter studentFilter = new StudentFilter();
		studentFilter.setName("xiaohei");
		studentFilter.setType("se");
		studentFilter.setUrl("warIII");
		filterRegistration.setFilter(studentFilter);
		
		
		String[] urlPatterns ={"/gogogo","/private/*"};
		filterRegistration.addUrlPatterns(urlPatterns);
		
		filterRegistration.setName("studentFilter");
		filterRegistration.addInitParameter("targetBeanName", "studentFilter");
		filterRegistration.addInitParameter("name","xiaobai");//暂时无效
		
		return filterRegistration;
		
	}
	
}
