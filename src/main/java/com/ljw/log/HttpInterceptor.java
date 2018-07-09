package com.ljw.log;

import java.util.Map;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.ljw.log.base.BaseInterceptor;
import com.ljw.log.base.SystemId;



@Aspect
@Component
public class HttpInterceptor extends BaseInterceptor{

	private static Logger log=Logger.getLogger(HttpInterceptor.class);
	
	
	@Pointcut("execution(* com.ljw.service.MyHttpService.*(..))")
	public void anyMethod(){
	}//定义切点
	
	@AfterThrowing(value = "anyMethod()", throwing = "ex")
	public void doThrowing(JoinPoint joinPoint, Throwable ex) {
		
		log.info("ljw.doThrowing");
		log.info(formatErrLogMsg(joinPoint, ex, SystemId.MYHTTP));
		
	}
	
	@Around("anyMethod()")
	public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable{
		log.info("ljw.doAround");
		long begin = System.currentTimeMillis();
		Object resultValue = joinPoint.proceed();
		long end = System.currentTimeMillis();
		long useTime = end-begin;
		String resultCode = "";
		if (resultValue instanceof java.util.Map) {
			Map<String, Object> resultMap = (Map<String, Object>)resultValue;
			resultCode = resultMap.toString();
		}else if (resultValue instanceof java.lang.String) {
			resultCode = (String)resultValue;
		}
		log.info(formatLogMsg(joinPoint, begin, useTime, resultCode, SystemId.MYHTTP));
		
		return resultValue;
		
	}
	
	
}
