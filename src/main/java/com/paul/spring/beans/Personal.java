package com.paul.spring.beans;/**
 * Created by zhouminmin on 2017/7/26.
 */

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

import java.io.Serializable;

/**
* @author  hzzhouminmin@corp.netease.com
* @since 2017/7/26
**/
public class Personal implements Serializable, BeanNameAware, BeanFactoryAware, InitializingBean, DisposableBean {

    private static final long serialVersionUID = -1L;

    private String name;

    private Integer age;

    private String gender;

    public Personal() {
        System.err.println("Personal的构造器中");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.err.println("设置name属性");
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
        System.err.println("设置age属性");
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
        System.err.println("设置Gender属性");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.err.println("调用Personal#setBeanFactory");
    }

    @Override
    public void setBeanName(String name) {
        System.err.println("调用Personal#setBeanName");
    }

    @Override
    public void destroy() throws Exception {
        System.err.println("调用Personal#destory");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.err.println("调用afterPropertiesSet");
    }
}
