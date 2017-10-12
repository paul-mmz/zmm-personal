package com.paul.proxy.cglib;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

public class TargetObjectCallbackFilter implements CallbackFilter {
    @Override
    public int accept(Method method) {
        if (method.getName().contains("method1")) {
            return 0;
        }
        if (method.getName().contains("method2")) {
            return 1;
        }
        if (method.getName().contains("method3")) {
            return 2;
        }
        return 0;
    }
}
