package com.paul.java;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLearn {

    public static void main(String[] args) throws IOException {
        InputStream in = PropertiesLearn.class.getResourceAsStream("/message.properties");
        if (in == null) {
            System.out.println("null");
            return;
        }
        Properties properties = new Properties();
        properties.load(in);
        System.out.println(properties.getProperty("wode"));
        System.out.println(properties.getProperty("user.host"));

    }
}
