package com.paul.proxy;

import java.lang.reflect.*;

public class InstanceProxy implements TestInterface, ShowProxy{
    @Override
    public String myHandlerFunction() {
        System.out.println("this is in my house");
        return this.getClass().getName();
    }

    private static ShowProxy source = new InstanceProxy();

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        ShowProxy proxy1 =(ShowProxy) Proxy.newProxyInstance(ShowProxy.class.getClassLoader(), new Class<?>[]{ShowProxy.class}, new InvocationHandler() {

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("在代理里面哟");
                return method.invoke(source, args);
            }
        });
        System.out.println(proxy1.myHandlerFunction());


        Class<?> proxyClass = Proxy.getProxyClass(ShowProxy.class.getClassLoader(), new Class<?>[]{ShowProxy.class});
        Constructor<?> constructor = proxyClass.getConstructor(InvocationHandler.class);
        ShowProxy proxy2 = (ShowProxy) constructor.newInstance(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object result = method.invoke(source, args);
                System.out.println("已经在代码之后了哟");
                return result;
            }
        });
        System.out.println(proxy2.myHandlerFunction());
        System.out.println(proxy2.getClass().getName());
        System.out.println(proxy1.getClass().getName());
        System.out.println(proxy2.getClass().getConstructor(InvocationHandler.class).getName());

    }

    @Override
    public void method1() {
        System.out.println("InstantceProxy, i'm the method1");
    }

    @Override
    public void method2() {
        System.out.println("InstatnceProxy, i'm the method2");
    }

    @Override
    public void method3() {
        System.out.println("InstantceProxy, i'm the method3");
    }
}
