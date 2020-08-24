package com.paul.leetcode;

public class CuttingRope {

    public int cuttingRope(int n) {
        if (n < 2) {
            return n;
        }

        long[] maxCuttingArr = new long[n + 1];
        maxCuttingArr[0] = 0;
        maxCuttingArr[1] = 1;

        for (int i = 2; i <= n; ++i) {
            int mid = i / 2;

            for(int j = 1; j <= mid; ++j) {
                maxCuttingArr[i] = Math.max(maxCuttingArr[i], ((Math.max(j, maxCuttingArr[j])) * (Math.max(i - j, maxCuttingArr[i - j]))));
            }
        }

        return (int) maxCuttingArr[n];
    }

    public int cuttingRope_bigData(int n) {
        if(n <= 3) return n - 1;
        int b = n % 3, p = 1000000007;
        long rem = 1, x = 3;
        for(int a = n / 3 - 1; a > 0; a /= 2) {
            if(a % 2 == 1) rem = (rem * x) % p;
            x = (x * x) % p;
        }
        if(b == 0) return (int)(rem * 3 % p);
        if(b == 1) return (int)(rem * 4 % p);
        return (int)(rem * 6 % p);
    }

    public static void main(String[] args) {
//        System.out.println(new CuttingRope().cuttingRope(58));
//
//        System.out.println(Integer.MAX_VALUE);


        System.out.println(new Integer("25.0"));
    }
}