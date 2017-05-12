/**
 * 
 */
package com.paul.spring.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @author hzzhouminmin
 *
 */
public class BeanFactoryProcessor implements BeanFactoryPostProcessor{

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.config.BeanFactoryPostProcessor#postProcessBeanFactory(org.springframework.beans.factory.config.ConfigurableListableBeanFactory)
	 */
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		
//		beanFactory.addBeanPostProcessor(new Processor1());
//		beanFactory.addBeanPostProcessor(new Processor2());
		
		BeanDefinition beanDefinition = beanFactory.getBeanDefinition("product2");
		MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
		if(propertyValues.contains("name")) {
			propertyValues.add("name", "这是我加的");
		}
		
	}

}
