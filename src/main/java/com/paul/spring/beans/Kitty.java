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
public class Kitty implements Serializable, BeanNameAware, BeanFactoryAware, InitializingBean, DisposableBean {

    private static final long serialVersionUID = -1L;

    private boolean animinal;

    private String name;

    private String owner;

    public Kitty() {
        System.err.println("Kitty的构造器中");
    }

    public boolean isAniminal() {
        return animinal;
    }

    public void setAniminal(boolean animinal) {
        this.animinal = animinal;
        System.err.println("设置animal属性");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.err.println("设置name属性");
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
        System.err.println("设置owner属性");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.err.println("调用Kitty#setBeanFactory");
    }

    @Override
    public void setBeanName(String name) {
        System.err.println("调用Kitty#setBeanName");
    }

    @Override
    public void destroy() throws Exception {
        System.err.println("调用Kitty#destory");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.err.println("调用Kitty#afterPropertiesSet");
    }
}
