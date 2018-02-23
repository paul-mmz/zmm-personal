package com.paul.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        new Thread(()-> System.out.println("new Thread")).start();

        Runnable runna = Main::f;
        Thread thread = new Thread(runna);
        thread.start();
        thread.join();

        List<String> strList = new ArrayList<String>() {
            {
                add("nihao");
                add("jjsf");
                add("psvm");
            }
        };

        Collections.sort(strList, String::compareToIgnoreCase);
        System.out.println(strList);


    }

    public static void f() {
        System.out.println("hello, i'm function");
    }
}
