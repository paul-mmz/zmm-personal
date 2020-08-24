package com.paul.leetcode;

public class MaxProfit {

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int minPrice = prices[0], maxProfit = 0;

        for (int i = 1; i < prices.length; ++i) {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }

        return maxProfit;
    }

    public static int maxProfit_buyMany(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        boolean buy = true;
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; ++i) {
            if (buy) {
                if (i + 1 >= prices.length || prices[i + 1] < prices[i]) {
                    continue;
                }

                buyPrice = prices[i];
                buy = false;
            } else {
                if (i + 1 >= prices.length) {
                    maxProfit += prices[i] - buyPrice;
                    continue;
                }

                if (prices[i + 1] > prices[i]) {
                    continue;
                }

                maxProfit += prices[i] - buyPrice;
                buy = true;
            }
        }

        return maxProfit < 0 ? 0 : maxProfit;
    }

    public static void main(String[] args) {
        final int[] prices = {1,2,3,4,5};
//        System.out.println(maxProfit(prices));
        System.out.println(maxProfit_buyMany(prices));

    }
}
