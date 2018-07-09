package com.ljw.exception;

/**
 * 所有的异常都继承此异常
 * 用于描述异常的信息
 * @author ljw
 *
 */
public abstract class BaseException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9207322021256300923L;
	
	public String code;
	public String msg;
	
	public BaseException(String code,String msg){
		super(new StringBuilder().append("[code]=").append(code).append("-----[msg]=").append(msg).toString());
		this.code = code;
		this.msg = msg;
		
	}

}
