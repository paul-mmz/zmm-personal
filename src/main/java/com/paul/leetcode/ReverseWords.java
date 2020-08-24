package com.paul.leetcode;

public class ReverseWords {

    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        String trim = s.trim();

        if (trim.length() == 1) {
            return trim;
        }

        String[] s1 = trim.split(" ");

        StringBuilder stringBuilder = new StringBuilder(s1[s1.length - 1]);

        for (int i = s1.length - 2; i >= 0; --i) {
            if (s1[i].length() > 0) {
                stringBuilder.append(" ").append(s1[i].trim());
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("  hello world!  "));
    }
}
