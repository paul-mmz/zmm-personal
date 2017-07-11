package com.paul.zmm_personal;/**
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
    }

    public static void f(){

    }

    public static class Inner {
        static {
            System.out.println("i'm in Inner static block");
        }
        public Inner() {
            System.out.println("i'm in Inner constructor");
        }
    }
}
