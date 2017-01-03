package com.paul.spring.event;

import org.springframework.context.ApplicationEvent;

public class DemoEvent extends ApplicationEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5864838820553170748L;

	private String msg;

	public DemoEvent(Object object, String msg) {
		super(object);
		this.msg = msg;
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}



}
