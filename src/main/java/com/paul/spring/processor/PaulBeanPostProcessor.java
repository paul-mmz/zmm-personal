package com.paul.spring.processor;/**
 * Created by zhouminmin on 2017/7/26.
 */

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
* @author  hzzhouminmin@corp.netease.com
* @since 2017/7/26
**/
public class PaulBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.err.println("调用PaulBeanPostProcessor#postProcessBeforeInitialization, beanName: " + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.err.println("调用PaulBeanPostProcessor#postProcessAfterInitialization, beanName: " + beanName);
        return null;
    }
}
