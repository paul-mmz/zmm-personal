package com.paul.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class BestSeqAtIndex {

    public static LongestIncreasingSubSequence longestIncreasingSubSequence = new LongestIncreasingSubSequence();

    /**
     * 具体而言：
     * 先根据身高 升序排序，若身高一样则根据体重 降序排序。（要求体重和升高都满足 < 非 <= 要求）
     *
     * 处理体重的问题就是处理最长递增子序列的问题 - 找到体重的最长递增子序列的长度，即答案
     *
     * 那么仔细想想为什么身高相同时，体重需要降序排序呢？
     *
     * 其实很简单的道理，将身高相同的人看成1个集合，若他们都按照体重升序来排序，则之后的二分法处理中，有一定的概率会在这集合中取 >= 2 个人作为最终结果。
     * 为什么说是“有一定的概率会在这集合中取 >= 2 个人作为最终结果”呢？
     * 比如:
     * 身高:[1, 2, 2, 3, 4]
     * 体重:[1, 3, 4, 5, 7]
     * 显然，在身高升序排序，且身高相同则体重升序排序的预处理后，对体重进行二分查找得到的最长递增子序列的结果是[1, 3, 4, 5, 7]，而体重为3、4的那2个人身高相同，不符合题意。
     * 如果 当身高相同时，按体重降序排序，则有
     * 身高:[1, 2, 2, 3, 4]
     * 体重:[1, 4, 3, 5, 7]
     * 此时体重的最长递增子序列是1-3-5-7或1-4-5-7，答案是4
     *
     */
    public int bestSeqAtIndex(int[] height, int[] weight) {
        if (height == null || weight == null || height.length == 0 || weight.length == 0) {
            return 0;
        }

        int[][] person = new int[height.length][2];

        for (int i = 0; i < height.length; ++i) {
            person[i] = new int[]{height[i], weight[i]};
        }

        Arrays.sort(person, new Comparator<int[]>() {

            @Override
            public int compare(int[] person1, int[] person2) {
                if (person1[0] == person2[0]) {
                    return Integer.compare(person1[1], person2[1]) * -1;
                } else {
                    return Integer.compare(person1[0], person2[0]);
                }
            }

        });

        Integer[] newWeight = new Integer[weight.length];

        for (int i = 0; i < person.length; ++i) {
            newWeight[i] = person[i][1];
        }

        return longestIncreasingSubSequence.lengthOfLIS_dpBetter(newWeight);
    }

    public static void main(String[] args) {
        int[] height = new int[]{65,70,56,75,60,60,68};
        int[] weight = new int[]{100,150,90,190,95,98,110};

        System.out.println(new BestSeqAtIndex().bestSeqAtIndex(height, weight));
    }

}
