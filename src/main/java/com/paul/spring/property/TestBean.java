package com.paul.spring.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by hzzhouminmin on 2017/12/11.
 */
@Component("testBean")
public class TestBean implements Serializable, EnvironmentAware{

    private Integer i;

    @Value("${user.host}")
    private String host;

    @Value("${user.passwd}")
    private String passwd;

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

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public Environment getEnvironment() {
        return environment;
    }
}
