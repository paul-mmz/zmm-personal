package com.paul.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static void lambda1(LambdaInterface lambdaInterface) {
        new Thread(() -> System.out.print("new Thread")).start();
        new Thread(() -> {System.out.print("new Thread");}).start();

        System.out.println(lambdaInterface.myprint("yyyyyyyyys"));

        Collections.sort(Arrays.asList(1,2), (Integer x, Integer y) -> {
            if (x > y) {
                return 1;
            }
            return -1;
        });

        lambdaInterface = (String s) -> {return s;};
        Predicate<String> sp1 = (String s) -> s.startsWith("j");
        Predicate<String> sp2 = (String s) -> s.startsWith("j");
        sp1.and(sp2);
    }

    public static void lambda2() {
        List<String> list = Arrays.asList("hello", "world", "ni", "hao");
        list.forEach((String s) -> {
            System.out.println(s);
        });

        list.forEach(System.out::println);

    }

    public static void stream() {
        List<Integer> integers = Arrays.asList(1,2,3,4,6);
        integers.forEach(System.out::println);
        integers.stream().forEach((Integer i) -> System.out.println(i));
        integers.stream().map((Integer i) -> {return i*i;}).forEach(System.out::println);
        Integer su = integers.stream().map((Integer i) -> {
            return i * i;
        }).reduce((sum, cost) -> sum + cost).get();
        System.out.println(su);
    }

    public static void main(String[] args) throws InterruptedException {

        lambda1((String s) -> {System.out.println(s); return s;});

        lambda2();

        stream();

    }

}
