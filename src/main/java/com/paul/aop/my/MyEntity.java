package com.paul.aop.my;

public class MyEntity implements MyInterface1, MyInterface2 {
    @Override
    public void function1() {
        System.out.println("I'm Interface1.function1....funtion one");
    }

    @Override
    public void function2() {
        System.out.println("I'm Interface2.function2....function two");
    }
}
