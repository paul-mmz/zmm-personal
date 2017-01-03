package com.paul.spring.configs;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
//@ComponentScan("com.paul.spring.configs")
public class ConfigBeanWithMain {

	@Bean(initMethod = "init", destroyMethod = "destroy")
	@Profile("dev")
	public BeanWayService beanWayService1() {
		BeanWayService beanWayService = new BeanWayService();
		beanWayService.setContent("DEV");
		return beanWayService;
	}

	@Bean(initMethod = "init", destroyMethod = "destroy")
	@Profile("production")
	public BeanWayService beanWayService2() {
		BeanWayService beanWayService = new BeanWayService();
		beanWayService.setContent("PRODUCTION");
		return beanWayService;
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		// DemoPrototypeService p1 =
		// context.getBean(DemoPrototypeService.class);
		// DemoPrototypeService p2 =
		// context.getBean(DemoPrototypeService.class);
		//
		// DemoSingletionService s1 =
		// context.getBean(DemoSingletionService.class);
		// DemoSingletionService s2 =
		// context.getBean(DemoSingletionService.class);
		//
		// System.out.println(p1 == p2);
		// System.out.println(s1 == s2);
		context.getEnvironment().setActiveProfiles("production");
		context.register(ConfigBeanWithMain.class);
		context.refresh();

		System.out.println(context.getBean(BeanWayService.class).getContent());
		context.close();
	}
}
