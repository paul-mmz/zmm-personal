package com.paul.leetcode;

import java.util.Arrays;
import java.util.Objects;

import com.sun.org.apache.bcel.internal.generic.SWAP;

/**
 * @author zmm233489
 * @date 2020/7/16
 */
public class HeapSort {

    public void heapSort(int[] nums) {
        if (Objects.isNull(nums) || nums.length < 2) {
            return;
        }

        for (int i = nums.length / 2 - 1; i >= 0; --i) {
            adjustMaxHeap(nums, nums.length, i);
        }

        for (int i = nums.length - 1; i > 0; --i) {
            swap(nums, i, 0);
            adjustMaxHeap(nums, i, 0);
        }
    }

    private void adjustMaxHeap(int[] nums, int numLength, int adjustIndex) {
        while (adjustIndex <= numLength / 2 - 1) {
            int left = 2 * adjustIndex + 1, right = 2 * adjustIndex + 2, maxIndex = -1;

            if (right >= numLength) {
                maxIndex = left;
            } else {
                maxIndex = nums[left] > nums[right] ? left : right;
            }

            if (nums[adjustIndex] >= nums[maxIndex]) {
                break;
            }

            swap(nums, adjustIndex, maxIndex);

            adjustIndex = maxIndex;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1,1,2,3,4,5};

        new HeapSort().heapSort(nums);

        Arrays.stream(nums).forEach(System.out::println);
    }
}
