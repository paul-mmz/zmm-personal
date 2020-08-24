package com.paul.leetcode;

public class MaxSubArray {

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int currentMinSum = 0, currentMaxSum = Integer.MIN_VALUE, currentSum = 0;

        for (int i = 0; i < nums.length; ++i) {
            currentSum += nums[i];
            currentMaxSum = Math.max(currentMaxSum, currentSum - currentMinSum);
            currentMinSum = Math.min(currentMinSum, currentSum);
        }

        return currentMaxSum;
    }

    public static int maxSubArray_greed(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int currentSum = nums[0], maxSubArrSum = nums[0];

        for (int i = 1; i < nums.length; ++i) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSubArrSum = Math.max(currentSum, maxSubArrSum);
        }

        return maxSubArrSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, -1, -2, -3};
        System.out.println(maxSubArray_greed(nums));
    }
}
