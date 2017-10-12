package com.paul.aop.my;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyAspect {

    @MyBefore(value = "function1", clazz = MyInterface1.class)
    public void before1() {
        System.out.println("myAspect before function...in before1");
    }

    @MyAfter(value = "function1", clazz = MyInterface1.class)
    public void after1() {
        System.out.println("myAspect after function...in after1");
    }

    @MyBefore(value = "function2", clazz = MyInterface2.class)
    public void before2() {
        System.out.println("myAspect before function...in before2");
    }

    @MyAfter(value = "function2", clazz = MyInterface2.class)
    public void after2() {
        System.out.println("myAspect after function...in after2");
    }

    @MyAround(value = "function1", clazz = MyInterface1.class)
    public Object around(Method method, Object source, Object[] args) throws InvocationTargetException, IllegalAccessException {
        System.out.println("myAspect around function...in around.before");
        Object result = method.invoke(source, args);
        System.out.println("myAspect around function...in around.after");
        return result;
    }
//
//    @MyReturn(value = "funciton2", clazz = MyInterface2.class)
//    public void retuurn2() {
//        System.out.println("myAspect returrn function...in retuurn");
//    }

//    @MyException(value = "function1", clazz = MyInterface1.class)
//    public void haveException() {
//        System.out.println("myAspection have excepiton...have exception");
//    }
}
