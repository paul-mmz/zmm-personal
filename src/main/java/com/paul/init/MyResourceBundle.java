package com.paul.init;


import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by hzzhouminmin on 2017/12/6.
 */
public class MyResourceBundle {
    public static void main(String[] args) {
        Locale local = new Locale("en", "US");
        ResourceBundle resource = ResourceBundle.getBundle("message", local);
        System.out.println(resource.getString("Max.book.price"));
        System.out.println(resource.getClass().getSimpleName());

        resource = ResourceBundle.getBundle("com.paul.init.MyBundleClass", Locale.SIMPLIFIED_CHINESE);
        System.out.println(resource.getObject("price"));
    }
}
