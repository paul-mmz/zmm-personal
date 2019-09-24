package com.paul.proxy;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Date;

public class ProxyManager implements FactoryBean<ShowProxy> {

    private int type;

    private ShowProxy proxy1;

    private ShowProxy proxy2;

    private Date date;

    public ProxyManager() {
    }

    public ProxyManager(int type, ShowProxy proxy1, ShowProxy proxy2) {
        this.type = type;
        this.proxy1 = proxy1;
        this.proxy2 = proxy2;
    }

    @Override
    public ShowProxy getObject() throws Exception {

        if (type != 1 && type != 2) {
            return null;
        }

        final Object source = type == 1 ? proxy1 : proxy2;

        ShowProxy finalObj =(ShowProxy) Proxy.newProxyInstance(ShowProxy.class.getClassLoader(), new Class<?>[]{ShowProxy.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("because type is " + type + ", i'm proxy" + type);
                return method.invoke(source, args);
            }
        });

        return finalObj;
    }

    @Override
    public Class<?> getObjectType() {
        return ShowProxy.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public ShowProxy getProxy1() {
        return proxy1;
    }

    public void setProxy1(ShowProxy proxy1) {
        this.proxy1 = proxy1;
    }

    public ShowProxy getProxy2() {
        return proxy2;
    }

    public void setProxy2(ShowProxy proxy2) {
        this.proxy2 = proxy2;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
