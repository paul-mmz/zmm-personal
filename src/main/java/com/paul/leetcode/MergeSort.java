package com.paul.leetcode;

import java.util.Arrays;
import java.util.Objects;


/**
 * @author zmm233489
 * @date 2020/7/16
 */
public class MergeSort {

    private int[] tempArr;

    public void mergeSort(int[] nums) {
        if (Objects.isNull(nums) || nums.length < 2) {
            return;
        }

        tempArr = new int[nums.length];

        innerMergeSort(nums, 0, nums.length - 1);
    }

    private void innerMergeSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }

        int mid = (low + high) >>> 1;

        innerMergeSort(nums, low, mid);
        innerMergeSort(nums, mid + 1, high);

        merge(nums, low, mid, high);

    }

    private void merge(int[] nums, int low, int mid, int high) {
        for (int i = 0; i < nums.length; ++i) {
            tempArr[i] = nums[i];
        }

        int index = low, i = low, j = mid + 1;

        while (i <= mid && j <= high) {
            if (tempArr[i] <= tempArr[j]) {
                nums[index++] = tempArr[i++];
            } else {
                nums[index++] = tempArr[j++];
            }
        }

        while (i <= mid) {
            nums[index++] = tempArr[i++];
        }

        while (j <= high) {
            nums[index++] = tempArr[j++];
        }
    }

    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1};

        new MergeSort().mergeSort(nums);

        Arrays.stream(nums).forEach(System.out::println);
    }
}
