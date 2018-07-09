package com.ljw.exception;

public class UserAccountSystemException extends BaseException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7092068326198376031L;
	
	public static final String REQPARAM_INVALID="params_error";
	
	public static final String UNSUPPORTED_ENCODING="unsupported encoding";

	public UserAccountSystemException(String code, String msg) {
		super(code, msg);
		
	}

}
