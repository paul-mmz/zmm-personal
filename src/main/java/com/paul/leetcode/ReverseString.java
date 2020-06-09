package com.paul.leetcode;

public class ReverseString {
    public static void reverseString(char[] s) {
        if (s == null) {
            return;
        }

        swapStr(s, 0, s.length - 1);
    }

    public static void swapStr(char[] s, int left, int right) {
        char temp;
        if (left < right) {
            temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            swapStr(s, left + 1, right - 1);
        }
    }

    public static void reversePrintChar(char[] s, int i) {
        if (i < s.length) {
            reversePrintChar(s, i + 1);
            System.out.print("\"" + s[i] + "\"");
            if (i != 0) {
                System.out.print(",");
            }
        }
    }

    public static void main(String[] args) {
        char[] s = new char[]{'h','e','l','l','o'};
        char[] s1 = new char[]{'H','a','n','n','a','h'};

        System.out.println(s);
        reverseString(s);
        System.out.println(s);

        System.out.println(s1);
        reverseString(s1);
        System.out.println(s1);

    }
}
