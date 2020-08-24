package com.paul.leetcode;

/**
 * @author zmm233489
 * @date 2020/8/15
 */
public class IsPalindrome {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        String xStr = String.valueOf(x);

        int i = 0, j = xStr.length() - 1;

        for (; i <= j && xStr.charAt(i) == xStr.charAt(j); ++i, --j) {}

        return i > j;
    }

    public boolean isPalindrome_mod(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reverseNum = 0;

        while (x > reverseNum) {
            reverseNum = reverseNum * 10 + x % 10;
            x = x / 10;
        }

        return x == reverseNum || x == reverseNum / 10;
    }

    public static void main(String[] args) {
        System.out.println(new IsPalindrome().isPalindrome_mod(10));
    }
}
