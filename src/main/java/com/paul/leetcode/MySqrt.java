package com.paul.leetcode;

public class MySqrt {

    public static int mySqrt(int x) {
        if (x <= 0) {
            return 0;
        }

        if (x <= 3) {
            return 1;
        }

        int mid = 0, left = 1, right = x;

        while (left < right) {
            mid = (left + right) / 2;


            long result = (long) mid * (long) mid;

            if (result > x) {
                right = mid;
                continue;
            }

            if (result == x) {
                return mid;
            }

            if (result < x) {
                left = mid + 1;
                continue;
            }
        }

        return left - 1;
    }

    public static void main(String[] args) {

    }
}
