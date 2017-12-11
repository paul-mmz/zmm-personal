package com.paul.spring;

import org.springframework.stereotype.Component;

/**
 * Created by hzzhouminmin on 2017/12/11.
 */
@Component
public class TestBean {

    private Integer i;

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
}
