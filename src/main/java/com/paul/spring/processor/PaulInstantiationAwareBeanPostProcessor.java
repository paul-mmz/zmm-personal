package com.paul.spring.processor;/**
 * Created by zhouminmin on 2017/7/27.
 */

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import java.beans.PropertyDescriptor;

/**
* @author  hzzhouminmin@corp.netease.com
* @since 2017/7/27
**/
public class PaulInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        return true;
    }

    @Override
    public PropertyValues postProcessPropertyValues(
            PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName)
            throws BeansException {
        System.err.println("调用PaulInstantiationAwareBeanPostProcessor#postProcessPropertyValues, beanName: " + beanName);
        return pvs;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.err.println("调用PaulInstantiationAwareBeanPostProcessor#postProcessBeforeInitialization, beanName: " + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.err.println("调用PaulInstantiationAwareBeanPostProcessor#postProcessAfterInitialization, beanName: " + beanName);
        return bean;
    }

}
