package com.paul.leetcode;

import java.util.Arrays;
import java.util.Objects;


/**
 * @author zmm233489
 * @date 2020/7/16
 */
public class TreeSort {

    private Val[] treeArr;

    public void treeSort(int[] nums) {
        if (Objects.isNull(nums) || nums.length < 2) {
            return;
        }

        treeArr = new Val[nums.length * 2];

        for (int i = nums.length; i < treeArr.length; ++i) {
            treeArr[i] = new Val(nums[i - nums.length], i);
        }

        for (int i = nums.length - 1; i > 0; --i) {
            int left = 2 * i, right = 2 * i + 1;
            treeArr[i] = treeArr[left].value > treeArr[right].value ? new Val(treeArr[left].value, treeArr[left].index) : new Val(treeArr[right].value, treeArr[right].index);
        }

        for (int i = nums.length - 1; i >= 0; --i) {
            nums[i] = treeArr[1].value;

            updateValue(treeArr, treeArr[1].index, Integer.MIN_VALUE);
        }
    }

    private void updateValue(Val[] treeArr, int index, int newValue) {
        while (index > 0) {
            if (2 * index >= treeArr.length) {
                treeArr[index].value = newValue;
            } else {
                int left = 2 * index, right = left + 1, maxIndex = -1;

                if (right >= treeArr.length) {
                    maxIndex = left;
                } else {
                    maxIndex = treeArr[left].value > treeArr[right].value ? left : right;
                }

                treeArr[index].value = treeArr[maxIndex].value;
                treeArr[index].index = treeArr[maxIndex].index;
            }

            index /= 2;
        }
    }

    class Val {
        int value;
        int index;

        public Val(int value, int index) {
            this.value = value;
            this.index = index;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1};

        new TreeSort().treeSort(nums);

        Arrays.stream(nums).forEach(System.out::println);
    }
}
