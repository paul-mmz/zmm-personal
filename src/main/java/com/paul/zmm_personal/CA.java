package com.paul.zmm_personal;

public class CA {

    public static CB cb = new CB();

    public CA() {
        System.out.println("CA constructor");
    }

    static {
        System.out.println("CA inner static");
    }
}
