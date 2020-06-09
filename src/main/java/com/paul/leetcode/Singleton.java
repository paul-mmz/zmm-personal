package com.paul.leetcode;

public class Singleton {

    private String s;

    private Singleton() {
        this.s = "the only one";
    }

    public String getS() {
        return this.s;
    }

    public static class SingletonHolder {

        private static Singleton instance;

        static {
            instance = new Singleton();
        }

        public static Singleton getInstance() {
            return instance;
        }
    }

}
