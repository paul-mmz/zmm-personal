package com.paul.spring.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.paul.spring.aop")
@EnableAspectJAutoProxy
public class ConfigBean {

}
