package com.paul.proxy.cglib;

public class InterfaceInstance implements TargetInterface {
    @Override
    public String f(String param) {
        System.out.println("hah ,wo jiuzai jiekou de f fangfa zhong: " + param);
        return param;
    }
}
