package com.paul.proxy.cglib;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

public class Main {
    public static void main(String[] args) {
        TargetObject proxy = (TargetObject) Enhancer.create(TargetObject.class,
                new TargetInterceptor(/**new TargetObject()*/));
        proxy.method1();

        System.out.println(proxy.method2("sha bi"));

        System.out.println(proxy.method3(90L));

        System.out.println("\n\n\n****************************\n\n\n");

        Callback[] callbacks = new Callback[] {
                new TargetInterceptor(new TargetObject(), new InterfaceInstance()),
                NoOp.INSTANCE,
                new TargetResultFixed()

        };
        Object ppp =  Enhancer.create(TargetObject.class,  new Class[]{TargetInterface.class},
                new TargetObjectCallbackFilter(), callbacks);

        TargetObject proxy2 = (TargetObject) ppp;

        proxy2.method1();

        System.out.println(proxy2.method2("sha bi"));

        System.out.println(proxy2.method3(90L));
//
//
//        System.out.println("\n\n\n****************************\n\n\n");
//
//
//        TargetInterface proxy3 = (TargetInterface) ppp;
//
//        System.out.println(proxy3.f("paul"));
    }
}
