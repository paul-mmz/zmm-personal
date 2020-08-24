package com.paul.leetcode;

import java.util.Objects;

/**
 * @author zmm233489
 * @date 2020/7/16
 */
public class QuickSort {

    public void quickSort(int[] nums) {
        if (Objects.isNull(nums) || nums.length < 2) {
            return;
        }

        innerQuickSort(nums, 0, nums.length - 1);
    }

    private int partation(int[] nums, int start, int end) {
        int temp = nums[end];

        while (start < end) {
            while (start < end && nums[start] < temp) {
                ++start;
            }

            nums[end] = nums[start];

            while (start < end && nums[end] >= temp) {
                --end;
            }

            nums[start] = nums[end];
        }

        nums[end] = temp;

        return end;
    }

    public void innerQuickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int midIndex = partation(nums, start, end);
        innerQuickSort(nums, start, midIndex - 1);
        innerQuickSort(nums, midIndex + 1, end);
    }
}
