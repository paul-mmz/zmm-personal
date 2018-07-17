package com.paul.spring.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by hzzhouminmin on 2017/12/11.
 */
//@Component("testBean")
public class TestBean implements Serializable, EnvironmentAware{

    private Integer i;

    @Value("${user.userHost}")
    private String userHost;

    @Value("${user.userPasswd}")
    private String userPasswd;

//    @Value("#{props.host}")
    private String host;

//    @Value("#{props.passwd}")
    private String passwd;

//    @Value("#{props.user}")
    private String user;

    private Environment environment;

    public TestBean() {
    }

    public TestBean(Integer i) {
        this.i = i;
    }

    public Integer getI() {
        return i;
    }

    public void setI(Integer i) {
        this.i = i;
    }

    public String getUserHost() {
        return userHost;
    }

    public void setUserHost(String userHost) {
        this.userHost = userHost;
    }

    public String getUserPasswd() {
        return userPasswd;
    }

    public void setUserPasswd(String userPasswd) {
        this.userPasswd = userPasswd;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
