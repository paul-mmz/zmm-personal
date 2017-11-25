package com.paul.jvm;

public class SuperClass {
    static {
        System.out.println("superClass init!");
    }

    public static final String value = "123";

    public static class SubClass extends SuperClass{
        static {
            System.out.println("subClass init!");
        }
    }
}
