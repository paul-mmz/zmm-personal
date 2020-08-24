package com.paul.leetcode;

import java.util.*;

public class LongestIncreasingSubSequence {

    private static LongestCommonSubSequence longestCommonSubSequence = new LongestCommonSubSequence();

    public int lengthOfLIS_lcs(Integer[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums == null ? 0 : nums.length;
        }

        Integer[] sortNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortNums);

        return longestCommonSubSequence.longestCommonSubSequenceLength(nums, sortNums);
    }

    public Set<List<Integer>> allLIS_lcs(Integer[] nums) {
        if (nums == null || nums.length == 0) {
            return new HashSet<>();
        }

        if (nums.length == 1) {
            return new HashSet(Arrays.asList(nums[0]));
        }

        Integer[] sortNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortNums);

        return longestCommonSubSequence.allLongestCommonSubSequence(nums, sortNums);
    }

    public int lengthOfLIS_dp(Integer[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums == null ? 0 : nums.length;
        }

        int[] lens = new int[nums.length];
        lens[0] = 1;

        int maxLisLen = 0;

        for (int i = 1; i < nums.length; ++i) {
            for (int j = 0; j < i; ++j) {
                lens[i] = Math.max(lens[i], nums[i] >= nums[j] ? lens[j] + 1 : 1);
            }

            maxLisLen = Math.max(maxLisLen, lens[i]);
        }

        return maxLisLen;
    }

    public int countOfLIS_dp(Integer[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums == null ? 0 : nums.length;
        }

        /**
         * maxLisLens 数组保存以第i个元素结尾（LIS一定包含该元素）的最长的LIS的长度
         */
        int[] maxLisLens = new int[nums.length];
        maxLisLens[0] = 1;

        /**
         * lis的最长长度
         */
        int maxLisLen = 0;

        /**
         * maxLensCount 数组保存以第i个元素结尾（LIS一定包含该元素）的最长LIS的个数
         */
        int[] maxLensCount = new int[nums.length];
        maxLensCount[0] = 1;

        for (int i = 1; i < nums.length; ++i) {

            int maxLenCount = 0;

            for (int j = 0; j < i; ++j) {

                int newLisLen = nums[i] >= nums[j] ? maxLisLens[j] + 1 : 1;

                if (newLisLen == maxLisLens[i] && nums[i] >= nums[j]) {
                    maxLenCount += maxLensCount[j];
                } else if (newLisLen > maxLisLens[i]){
                    maxLisLens[i] = newLisLen;
                    maxLenCount = maxLensCount[j];
                }
            }

            maxLensCount[i] = maxLenCount;

            maxLisLen = Math.max(maxLisLen, maxLisLens[i]);
        }

        int maxLenLisCount = 0;

        for (int i = 0; i < maxLisLens.length; ++i) {
            if (maxLisLen == maxLisLens[i]) {
                maxLenLisCount += maxLensCount[i];
            }
        }

        return maxLenLisCount;
    }

    public int lengthOfLIS_dpBetter(Integer[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums == null ? 0 : nums.length;
        }

        int[] lenLastMin = new int[nums.length + 1];
        lenLastMin[0] = Integer.MIN_VALUE;
        int currentLen = 0;

        for (int i = 0; i < nums.length; ++i) {
            int replaceIndex = -1;

            if (nums[i] >= lenLastMin[currentLen]) {
                replaceIndex = ++currentLen;
            } else {
                replaceIndex = binarySearchLisReplaceIndex_jdk(lenLastMin, 0, currentLen, nums[i]);
            }

            lenLastMin[replaceIndex] = nums[i];
        }

        return currentLen;
    }

    public int countOfLIS_dpBetter(Integer[] nums) {
        return 0;
    }

    public int binarySearchLisReplaceIndex(int[] nums, int startIndex, int endIndex, Integer replace) {
        int left = startIndex, right = endIndex, mid = 0;

        while (left < right) {
            mid = (left + right) / 2;

            if (replace == nums[mid]) {
                return mid;
            }

            if (replace > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }

    public int binarySearchLisReplaceIndex_jdk(int[] nums, int startIndex, int endIndex, Integer replace) {
        int find = Arrays.binarySearch(nums, startIndex, endIndex + 1, replace);

        return find < 0 ? -(find + 1) : find;
    }

    public static void main(String[] args) {
        Integer[] nums = {2, 1, 5, 3, 6, 4, 8, 9, 7};
        //Integer[] nums = {2,2,2,2,2};
        System.out.println(new LongestIncreasingSubSequence().lengthOfLIS_dpBetter(nums));
        //System.out.println(new LongestIncreasingSubSequence().countOfLIS_dp(nums));
//        System.out.println(new LongestIncreasingSubSequence().allLIS_lcs(nums));
    }




}
