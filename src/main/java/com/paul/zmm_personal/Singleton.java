package com.paul.zmm_personal;/**
 * Created by zhouminmin on 11/07/2017.
 */
/**
* @author  hzzhouminmin@corp.netease.com
* @since 11/07/2017
**/
public class Singleton {

    public static void f() {
        System.out.println("in f()");
    }

    private Singleton() {
        System.out.println("in singleton");
    }

    public static Singleton getInstance() {
        return InnerSingleton.instance;
    }

    private static class InnerSingleton {
        private static Singleton instance = new Singleton();
    }
}
