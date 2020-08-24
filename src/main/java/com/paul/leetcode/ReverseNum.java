package com.paul.leetcode;

/**
 * @author zmm233489
 * @date 2020/8/14
 */
public class ReverseNum {

    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }

        long y = Math.abs(x), z = 0;

        while(y > 0) {
            z = z * 10 + y % 10;
            y = y / 10;
        }

        if (z > Integer.MAX_VALUE) {
            return 0;
        }

        return (int) (x < 0 ? z * -1 : z);
    }

    public int reverse_1(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseNum().reverse(123));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}
