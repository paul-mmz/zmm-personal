package com.paul.spring.configs;

import org.springframework.stereotype.Component;

/**
 * Created by hzzhouminmin on 2017/12/11.
 */
@Component
public class TestBean1 {
    private Integer i;

    public TestBean1() {
    }

    public TestBean1(Integer i) {
        this.i = i;
    }

    public Integer getI() {
        return i;
    }

    public void setI(Integer i) {
        this.i = i;
    }
}