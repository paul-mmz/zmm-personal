package com.paul.java8;

import com.paul.spring.beans.Personal;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

        System.out.println(integers.stream().reduce((a,b) -> {return a+b;}).get());
        System.out.println(integers.stream().reduce(10, (a,b) -> {return a+b;}));

        Integer suu = integers.stream().reduce(2, (a, b) -> {return a * b;});
        System.out.println(suu);
    }

    public static void main(String[] args) throws InterruptedException, IOException {

        lambda1((String s) -> {System.out.println(s); return s;});

        lambda2();

        stream();

        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)
        );

//        System.err.println(inputStream.collect(Collectors.summingInt((t) -> t.stream().reduce(0, (a, b) -> a + b))));

//        System.err.println(inputStream.collect(Collectors.summingInt(t -> t.stream().collect(Collectors.summingInt(i -> i)))));

        Stream<Integer> outputStream = inputStream.flatMap((childList) -> childList.stream().map(x -> x*x));
        outputStream.forEach(System.out::println);

        Supplier<Personal> p = Personal::new;
        System.out.println(p.getClass().getName());
        Personal personal = p.get();

        IntStream.rangeClosed(1, 100).boxed().
                flatMap((a) ->
                        IntStream.rangeClosed(a, 100).boxed().
                                filter((b) -> Math.sqrt(a * a + b * b) % 1 == 0)
                                .map(b -> new Integer[]{a, b, (int) Math.sqrt(a * a + b * b)})).
                limit(5).forEach((Integer[] arr) -> System.out.println(arr[0] + ", " + arr[1] + ", " + arr[2]));


//        Stream.iterate(new Integer[]{0 ,1}, (a) -> new Integer[]{a[1], a[0] + a[1]}).limit(10).
//                forEach((a) -> System.out.print(a[1]));

        Stream.generate(new Supplier<Integer>() {

            private Integer before = 0;
            private Integer current = 1;

            @Override
            public Integer get() {
                Integer ret = before + current;
                before = current;
                current = ret;
                return before;
            }
        }).limit(10).forEach(System.out::print);

    }

}
