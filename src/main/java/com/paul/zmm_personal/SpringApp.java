package com.paul.zmm_personal;

import com.paul.proxy.ProxyManager;
import com.paul.proxy.ShowProxy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApp {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        ProxyManager bean = (ProxyManager)context.getBean("&proxyManager");
        bean.setType(2);
        ShowProxy object = bean.getObject();
        System.out.println(object.myHandlerFunction());

        bean.setType(1);
        object = bean.getObject();
        System.out.println(object.myHandlerFunction());
    }
}
