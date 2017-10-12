package com.paul.proxy.cglib;

public class TargetObject {

    public void method1() {
        System.out.println("i'm in targetObject method1");
    }

    public String method2(String param) {
        System.out.println("i'm in targetObject method2: " + param);
        return param;
    }

    public Long method3(Long l) {
        System.out.println("i'm in targetObject method3: " + l);
        return l;
    }
}
