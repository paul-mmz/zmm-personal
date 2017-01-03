package com.paul.spring.configs;

public class BeanWayService {
	
	private String content;
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public BeanWayService(){
		System.out.println("constructor BeanWayService()");
	}
	
	public void init(){
		System.out.println("init()");
	}
	
	public void destroy(){
		System.out.println("destroy()");
	}
}
