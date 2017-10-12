package com.paul.proxy;

import java.lang.reflect.InvocationHandler;  
import java.lang.reflect.Method;  
import java.lang.reflect.Proxy;  
  
  
public class DynamicProxy implements InvocationHandler{  
      
    private Object source;  
      
    public DynamicProxy(Object source) {  
        super();  
        this.source = source;  
    }  
  
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {  
        System.out.println("接口的方法全部变成这样了");
        if (method.getName().contains("method1")) {
            System.out.println("切在method1前");
        } else if (method.getName().contains("method2")) {
            System.out.println("切在method2前");
        } else if (method.getName().contains("method3")) {
            System.out.println("切在method3前");
        }

        System.out.println(method.getDeclaringClass().getName());
//        return method.invoke(proxy, args);
        return method.invoke(source, args);
    }  
    
//    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {  
//        System.out.println("before");  
//        Method sourceMethod = source.getClass().getDeclaredMethod(method.getName(), method.getParameterTypes());  
//        sourceMethod.setAccessible(true);  
//        Object result = sourceMethod.invoke(source, args);  
//        System.out.println("after");  
//        return result;  
//    } 
      
    public static void main(String[] args) {  
        //只要你传入就可以强转成功  
        TestInterface object =  (TestInterface) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                new Class[]{TestInterface.class}, new DynamicProxy(new TestClass()));
        object.method1();  
        object.method2();  
        object.method3();  
    }  
}