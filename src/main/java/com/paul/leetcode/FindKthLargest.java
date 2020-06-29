package com.paul.leetcode;

public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return -1;
        }

        int start = 0, end = nums.length - 1;


        while (true) {
            int i = start, j = end, key = nums[end];

            while (i < j) {
                while (i < j && nums[i] >= key) {
                    ++i;
                }

                nums[j] = nums[i];

                while (i < j && nums[j] < key) {
                    --j;
                }

                nums[i] = nums[j];
            }

            nums[j] = key;

            if (k - 1 == j) {
                return key;
            }

            if (k - 1 < j) {
                end = j - 1;
            } else {
                start = j + 1;
            }
        }
    }
}
