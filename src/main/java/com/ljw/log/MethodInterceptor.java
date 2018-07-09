package com.ljw.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MethodInterceptor {
	
	@Pointcut("within(com.ljw.cache.CacheManager)")
	public void methodPointCut(){
	}
	
	@Before("methodPointCut()")
	public void test(JoinPoint joinPoint){
		System.out.println(12122);
		
	}
	
}
