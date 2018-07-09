package com.ljw.mq.handler;

import com.ljw.mq.IEventHandler;


/**
 * mq消息辅助接受类
 * 
 * @author PC
 *
 */
public class MqHandlerReceiver implements IEventHandler{

	@Override
	public void onEventReceived(String message) {
		
		
		System.out.println("Customer Received [message="+message+"]");
		
	}

}
