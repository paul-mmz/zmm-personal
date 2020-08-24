package com.paul.leetcode;

import java.util.HashMap;
import java.util.Map;

public class WaysToChange {

    private static Map<Integer, Integer> changeWayMap = new HashMap<>();

    private final int mod = 1000000007;
    private final int[] coins = {25,10,5,1};

    public int waysToChange_1(int n) {
        int[] res = new int[n + 1];
        res[0] = 1;
        for(int coin : coins){
            for(int i = coin;i <= n;i++){
                res[i] = (res[i] + res[i - coin]) % mod;
            }
        }
        return res[n];
    }

    public int waysToChange_2(int n) {

        int[] dp = new int[n + 1];

        int[] coins = new int[]{1,5,10,25};


        //刚好可以用一个硬币凑成的情况，是一种情况
        // while i == coin :
        //dp[i] = dp[i - coin] => dp[0]
        dp[0] = 1;

        /**
         * dp方程：dp[i] += dp[i - coin];
         */

        for(int coin : coins) {
            for(int i = coin; i <= n; i++) {
                dp[i] = (dp[i] + dp[i - coin]) % 1000000007;
            }
        }

        return dp[n];
    }

    public int waysToChange(int n) {
        if (n < 5) {
            return 1;
        }

        int[] coins = {25, 10, 5, 1};

        for (int i = coins.length - 1; i >= 0; --i) {
            changeWayMap.put(coins[i], changeKind(coins[i], coins));
        }

        return changeKind(n, coins);
    }

    private int changeKind(int money, int[] coins) {
        if (money < 5) {
            return 1;
        }

        int changCnt = 0;

        for (int i = 0; i < coins.length; ++i) {
            int moneyCopy = money;

            if (moneyCopy < coins[i]) {
                continue;
            }

            changCnt += 1;
            moneyCopy -= coins[i];

            for (int j = i; j < coins.length; ++j) {
                if (moneyCopy < coins[j]) {
                    continue;
                }

                int iCoinNum = moneyCopy / coins[j];
                moneyCopy = moneyCopy % coins[j];

                changCnt += iCoinNum > 0 ? iCoinNum * (changeWayMap.getOrDefault(coins[j], 0) - 1) : 0;
            }
        }

        return changCnt;
    }

    public static void main(String[] args) {
        WaysToChange waysToChange = new WaysToChange();
        System.out.println(waysToChange.waysToChange_1(25));
        System.out.println(waysToChange.waysToChange_2(25));
        System.out.println(waysToChange.waysToChange(25));
    }
}
