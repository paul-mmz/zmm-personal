package com.paul.zmm_personal;

import java.util.Calendar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.paul.spring.beans.Product;

public class SpringApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Product p = context.getBean("product", Product.class);
        p.setName("paul");
        System.out.println(p.getName());
        
        Calendar c = context.getBean("calendar", Calendar.class);
        
        System.out.println(c.getTimeInMillis());
        
        Product p1 = context.getBean("product1", Product.class);
        System.out.println(p1.getCategory());
        
        Product p2 = context.getBean("product2", Product.class);
        System.out.println(p2.getCalendar().getTimeInMillis());
    }
}
