package com.paul.spring;

import com.paul.spring.event.DemoEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:properties.xml");
        Environment environment = context.getEnvironment();
        System.out.println(environment.getProperty("user.host"));
        System.out.println(System.getProperty("user.host"));

        DemoEvent demoEvent = (DemoEvent)context.getBean("demoEvent");
        System.out.println(demoEvent.getMsg());
    }
}
