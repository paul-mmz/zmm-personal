package com.paul.temp;/**
 * Created by zhouminmin on 12/07/2017.
 */
/**
* @author  hzzhouminmin@corp.netease.com
* @since 12/07/2017
**/
public class Outer {

    static {
        System.out.println("i'm in Outer static block");
    }
    public Outer() {
        System.out.println("i'm in Outer constructor");
        System.out.println("我就想加一句");
    }

    public static void f(){

    }

    public static class Inner {
        static {
            System.out.println("i'm in Inner static block");
        }
        public Inner() {
            System.out.println("i'm in Inner constructor");
            System.out.println("我就想加一句");
        }
    }
}
