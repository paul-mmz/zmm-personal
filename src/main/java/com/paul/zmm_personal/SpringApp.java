package com.paul.zmm_personal;

import com.paul.proxy.ProxyManager;
import com.paul.proxy.ShowProxy;
import com.paul.spring.beans.Product;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class SpringApp {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Product product1 = (Product)context.getBean("product2");
        System.out.println(product1.getName());

//        ProxyManager bean = (ProxyManager)context.getBean("&proxyManager");
//        bean.setType(2);
//        ShowProxy object = bean.getObject();
//        System.out.println(object.myHandlerFunction());
//
//        bean.setType(1);
//        object = bean.getObject();
//        System.out.println(object.myHandlerFunction());
    }

     public static class FileSystemXmlApplicationContextMain {
        public static void main(String[] args) {
            ApplicationContext fileSystemContext = new FileSystemXmlApplicationContext("classpath:/applicationContext.xml");
            Product product2 = (Product) fileSystemContext.getBean("product2");
            System.out.println(product2.getName());
        }
    }

    public static class XmlBeanFactoryMain {
        public static void main(String[] args) {
            XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
            Product product2 = (Product)xmlBeanFactory.getBean("product2");
            System.out.println(product2.getName());

        }

    }
}
