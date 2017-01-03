package com.paul.spring.inject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ConfigBean.class);
		UseFunctionService service = context.getBean(UseFunctionService.class);
		
		System.out.println(service.sayHello("haode"));
	}
}
