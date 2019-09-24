package com.paul.zmm_personal;

import com.paul.proxy.ProxyManager;
import com.paul.spring.beans.Personal;
import com.paul.spring.beans.Product;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.text.SimpleDateFormat;

public class SpringApp {

    private static String format = "yyyy-MM-dd HH:mm:ss";

    private static SimpleDateFormat dateFormat = new SimpleDateFormat(format);

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        ProxyManager proxyManager = (ProxyManager)context.getBean("&proxyManager");
        System.out.println(dateFormat.format(proxyManager.getDate()));
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
            Personal personalS = (Personal) xmlBeanFactory.getBean("personalS");
            System.out.println(personalS);
            System.out.println(personalS.getProduct());
            System.out.println(personalS.getKitty());
        }

    }
}
