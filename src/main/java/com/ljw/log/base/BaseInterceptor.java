package com.ljw.log.base;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.ljw.util.DateUtil;
import com.ljw.util.IpNetUtil;


/**
 * log日志格式
 * 
 * @author PC
 *
 */
public class BaseInterceptor {
	
	
	
	/**
	 * 获取调用的调用方法名
	 * @param jp
	 * @return
	 */
	protected String getMethodName(JoinPoint jp){
		if (jp == null) {
			return "";
		}
		return jp.getSignature().getName();
	} 
	
	/**
	 * 切点方法的输入参数列表
	 * @param jp
	 * @return
	 */
	protected String getArgs(JoinPoint jp) {
		String argsStr = "";
		if (jp != null) {
			Object[] arguments = jp.getArgs();
			if (arguments != null) {
				for (Object arg : arguments) {
					if (arg == null) {
						argsStr += "$null";
					} else {
						argsStr += "$" + arg.toString();
					}
				}
			}
		}
		return argsStr;
	}
	
	/**
	 * 额外记录参数(自己想要添加的必要信息)
	 * TODO:暂时不需要
	 * @return
	 */
	protected String getExtArgs() {
		//TODO:暂时不需要
		
		return "null";
		
	}
	
	/**
	 * 发送方
	 * @return
	 */
	protected String getSystemName() {
		if(RequestContextHolder.getRequestAttributes() != null) {
			HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest(); 
			//return request.getContextPath().substring(1);
			return "ljw"+request.getContextPath();
		}
		return "ljw";
	}
	
	/**
	 * 格式化日志
	 * @param jp
	 * @param begin
	 * @param useTime
	 * @param resultCode
	 * @param destSystem
	 * @return
	 */
	protected String formatLogMsg(JoinPoint jp, long begin, long useTime, String resultCode, SystemId destSystem) {
		String logContent = String.format("%s|%s|%s|%s|%s|%s|%s|%s|%s", getSystemName(), destSystem, getIp(), 
				DateUtil.formatDate("yyyyMMddHHmmss", new Date(begin)), useTime, 
				getMethodName(jp), getArgs(jp), getExtArgs(), resultCode);
		return logContent;
	}
	
	/**
	 * 格式化异常日志
	 * @param jp
	 * @param exception
	 * @param destSystem
	 * @return
	 */
	protected String formatErrLogMsg(JoinPoint jp, Throwable exception, SystemId destSystem) {
		String logContent = String.format("%s|%s|%s|%s|%s|%s|%s|%s", getSystemName(), destSystem, getIp(), 
				DateUtil.formatDate("yyyyMMddHHmmss", new Date()),
				getMethodName(jp), getArgs(jp), getExtArgs(), exception);
		return logContent;
	}
	
	/**
	 * 获取ip：(默认内网ip)
	 * @return
	 */
	protected String getIp(){
		return IpNetUtil.getInnerIp();//内网ip
		//return IpNetUtil.getIp();//外网ip
	}
}

