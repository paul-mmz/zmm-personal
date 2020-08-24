package com.paul.leetcode;

public class MySqrt {

    public static int mySqrt(int x) {
        if (x <= 0) {
            return 0;
        }

        if (x <= 3) {
            return 1;
        }

        long mid = 0, left = 1, right = x;
        long result = 0;

        while(left < right) {
            mid = (left + right) / 2;

            result = mid * mid;

            if (result > x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return (int) (left - 1);
    }

    public static int mySqrt_2(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long)mid * (long) mid <= x) {
                ans = mid;
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public static void reverseString(char[] s) {
        System.out.print("[");
        if (s != null) {

        }

        System.out.print("]");

    }

    public static void main(String[] args) {
//        System.out.println(mySqrt(2147483647));
//        System.out.println(mySqrt_2(2147483647));

        System.out.println("yes");

        System.out.println(System.getProperty("env"));
        System.out.println(System.getProperty("envGroup"));

    }
}
