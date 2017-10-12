package com.paul.aop.my;

public class Main {
    public static void main(String[] args) {
        MyContext context = new MyContext();
        MyInterface1 bean1 = (MyInterface1) context.getBean("myEntity");
        if (bean1 != null) {
            bean1.function1();
        }

        System.out.println("**************************");

        MyInterface2 bean2 = (MyInterface2) context.getBean("myEntity");
        if (bean2 != null) {
            bean2.function2();
        }


    }
}
