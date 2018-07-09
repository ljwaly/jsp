package com.ljw.exception.sonexception;

import com.ljw.exception.BaseException;

/**
 * 输入参数异常
 * @author PC
 *
 */

public class WrongParamException extends BaseException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3274172168739887978L;
	
	
	private static String CODE="param_error";
	
	public WrongParamException(String msg) {
		super(CODE, msg);
		
	}

}
