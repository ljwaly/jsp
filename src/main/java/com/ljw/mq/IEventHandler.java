package com.ljw.mq;

/**
 * mq消息辅助接收接口
 * 
 * 可以暴露给外部使用
 * 
 * @author PC
 *
 */
public interface IEventHandler{

	/**
	 * 
	 * 实现对mq的消息的处理
	 * 
	 * @param message 接收到的mq消息
	 */
	void onEventReceived(String message);
	
}
