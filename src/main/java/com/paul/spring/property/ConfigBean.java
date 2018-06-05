package com.paul.spring.property;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
@ComponentScan
@ImportResource("classpath:properties.xml")
//@PropertySource("classpath:message.properties")
//@PropertySource("classpath:config/application.properties")
public class ConfigBean {

//    @Bean
//    public PropertiesFactoryBean getPropertiesFactory() {
//        PropertiesFactoryBean bean = new PropertiesFactoryBean();
//        ClassPathResource source = new ClassPathResource("message.properties");
//        bean.setLocations(source);
//        return bean;
//    }

//    @Bean
//    public BeanFactoryPostProcessor getPropertyPlaceholderConfigurer() {
//        PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
//        ClassPathResource source = new ClassPathResource("message.properties");
//        configurer.setLocations(source);
//        return configurer;
//    }

//    @Bean
//    public BeanFactoryPostProcessor getPropertySourcesPlaceholderConfigurer() {
//        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
//        ClassPathResource source = new ClassPathResource("message.properties");
//        configurer.setLocations(source);
//        return configurer;
//    }
}
