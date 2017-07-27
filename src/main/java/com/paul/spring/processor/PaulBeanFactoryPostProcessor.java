package com.paul.spring.processor;/**
 * Created by zhouminmin on 2017/7/26.
 */

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
* @author  hzzhouminmin@corp.netease.com
* @since 2017/7/26
**/
public class PaulBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        BeanDefinition personal = beanFactory.getBeanDefinition("personal");
        personal.setAttribute("name", "在aulBeanFactoryPostProcessor#postProcessBeanFactory修改的名字");
        System.err.println("调用PaulBeanFactoryPostProcessor#postProcessBeanFactory，bean名字：" + beanDefinitionNames);
    }
}
