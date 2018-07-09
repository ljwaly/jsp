package com.ljw.exception.sonexception;

import com.ljw.exception.BaseException;



/**
 * 参数配置异常
 * @author ljw
 *
 */
public class MyConfException extends BaseException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2331786062038967820L;

	private static String _CODE="error_wrong_conf_properties";
	
	public MyConfException(String msg) {
		super(_CODE, msg);
		
	}

}
