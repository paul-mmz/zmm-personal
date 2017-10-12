package com.paul.aop.my;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class MyInvocationHandler implements InvocationHandler{

    /**
     * 保存接口方法执行时需要织入的切面方法Method
     */
    private static Map<String, Map<String, Method>> functionAspectFunctionMap = new HashMap<>();

    /**
     * 被代理的对象
     */
    private Object target;

    /**
     * 需要执行的切面对象实例,这里暂时只有MyAspect，实际比这复杂的多
     */
    private MyAspect aspect;


    public MyInvocationHandler(Object target, Map<String, Map<String, Method>> functionAspectFunctionMap, MyAspect aspect) {
        this.target = target;
        this.functionAspectFunctionMap = functionAspectFunctionMap;
        this.aspect = aspect;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method == null) {
            return null;
        }

        Map<String, Method> stringMethodMap = functionAspectFunctionMap.get(method.getName());

        /** 没有需要执行的切面方法 */
        if (stringMethodMap == null || stringMethodMap.size() <= 0) {
            return method.invoke(target, args);
        }

        Object result = null;

        /** 执行@MyBefore注解方法 */
        Method beforeMethod = stringMethodMap.get("before");
        if (beforeMethod != null) {
            beforeMethod.invoke(aspect, null);
        }

        /** 执行@MyAround注解方法 */
        Method aroundMethod = stringMethodMap.get("around");
        try {
            if (aroundMethod != null) {
                result = aroundMethod.invoke(aspect, method, target, args);
            } else {
                result = method.invoke(target, args);
            }
        } catch(Exception e) {
            /** 执行@MyException注解方法 */
            Method exceptionMethod = stringMethodMap.get("exception");
            if (exceptionMethod != null) {
                exceptionMethod.invoke(aspect, null);
            }
        }

        /** 执行@MyAfter注解方法 */
        Method afterMethod = stringMethodMap.get("after");
        if (afterMethod != null) {
            afterMethod.invoke(aspect, null);
        }

        /** 执行@MyReturn注解方法 */
        Method returnMethod = stringMethodMap.get("return");
        if (returnMethod != null) {
            returnMethod.invoke(aspect, null);
        }

        return result;
    }
}
