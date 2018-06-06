package com.paul.spring.property;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;


public class Main {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:properties.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigBean.class);
        Environment environment = context.getEnvironment();


//        System.out.println(environment.getProperty("user.host"));

        TestBean bean = (TestBean)context.getBean("testBean");
        System.out.println(bean.getUserHost());
        System.out.println(bean.getUserPasswd());

        System.out.println(bean.getHost());
        System.out.println(bean.getPasswd());
        System.out.println(bean.getUser());

    }
}
