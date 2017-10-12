package com.paul.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class TargetInterceptor implements MethodInterceptor {


    private Object target = null;

    private Object inter = null;

    public TargetInterceptor(Object target, Object inter) {
        this.target = target;
        this.inter = inter;
    }

    public TargetInterceptor() {
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {

        System.out.println("方法调用前");

        if (method.getName().contains("method1")) {
            System.out.println("qie ru method1 zhong");
        } else if (method.getName().contains("method2")) {
            System.out.println("qie ru method2 zhong");
        } else if (method.getName().contains("method3")) {
            System.out.println("qie ru method3 zhong");
        }
        Object result = null;
//        Object result = proxy.invoke(obj, args);
//        System.out.println(method.getDeclaringClass().getName());
        if (target == null) {
            result = proxy.invokeSuper(obj, args);
//            result = method.invoke(obj, args);
        } else {
            result = method.invoke(target, args);
        }
        System.out.println("方法调用后");

        return result;
    }
}
