package com.paul.jvm;

public class OverLoadClass {

    static abstract class Human {
        public String say() {
            return "human";
        }

        public String hello(Human huamn) {
            return "human";
        }
    }

    static class Man extends Human {
        public String say() {
            return "man";
        }

        public String hello(Man man) {
            return "man";
        }
    }

    static class Woman extends Human {
        public String say() {
            return "woman";
        }

        public String hello(Woman woman) {
            return "woman";
        }
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();

        System.out.println(man.say());
        System.out.println(woman.say());

        System.out.println(man.hello(man));
        System.out.println(woman.hello(woman));
    }


}
