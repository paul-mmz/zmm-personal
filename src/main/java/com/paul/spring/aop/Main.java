package com.paul.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				ConfigBean.class);
		DemoAnnotationService demoAnnotationService = applicationContext.getBean(DemoAnnotationService.class);
		DemoMethodService demoMethodService = applicationContext.getBean(DemoMethodService.class);

		demoAnnotationService.add();

		demoMethodService.add();

		applicationContext.close();
	}
}
