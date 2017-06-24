package com.paul.zmm_personal;

import java.util.UUID;

public class App {


    public static void main(String[] args) {
        System.out.println("Hello World");

        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
        for (char c : "THIS IS A StRING".toCharArray()) {
            System.out.println(c);
        }
        System.out.println(args.getClass().getName().toString());
        System.out.println("STRING".getClass().getName().toString());
    }
}