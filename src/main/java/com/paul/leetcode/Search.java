package com.paul.leetcode;

import java.util.Arrays;

public class Search {

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        if (nums.length == 1 && nums[0] != target) {
            return -1;
        }

        if (nums[0] == target) {
            return 0;
        }

        if (nums[nums.length - 1] == target) {
            return nums.length - 1;
        }

        int result = -1;

        if (nums[0] < nums[nums.length - 1]) {
            result = Arrays.binarySearch(nums, 0, nums.length, target);
            return result >= 0 ? result : -1;
        }

        // 在[i, j)里是完全递增排序的，在这里使用二分法查找
        // 在[k, l)找满足要求的 i 或者 j
        int i = -1, j = -1, k = -1, l = -1, m = -1;

        if (target > nums[0]) {
            i = 0;

            k = 0;
            l = nums.length;

            while (k < l) {
                m = (k + l) / 2;
                if (target == nums[m]) {
                    return m;
                }

                if (target < nums[m]) {
                    j = m;
                    break;
                }

                if (nums[m] < nums[i]) {
                    l = m;
                    continue;
                }

                if (target > nums[m]) {
                    i = m + 1;
                    k = m + 1;
                    continue;
                }
            }

            if (k == l) {
                return -1;
            }
        }

        if (target < nums[nums.length - 1]) {
            j = nums.length;

            k = 0;
            l = nums.length;

            while (k < l) {
                m = (k + l) / 2;

                if (target == nums[m]) {
                    return m;
                }

                if (target > nums[m]) {
                    i = m + 1;
                    break;
                }

                if (nums[m] > nums[j - 1]) {
                    k = m + 1;
                    continue;
                }

                if (target < nums[m]) {
                    j = m;
                    l = m;
                    continue;
                }
            }

            if (k == l) {
                return -1;
            }
        }

        if (i == -1 || j == -1) {
            return -1;
        }

        result = Arrays.binarySearch(nums, i, j, target);
        return result >= 0 ? result : -1;
    }

    public static int search_1(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        if (nums.length == 1 && nums[0] != target) {
            return -1;
        }

        if (nums[0] == target) {
            return 0;
        }

        if (nums[nums.length - 1] == target) {
            return nums.length - 1;
        }

        int result = -1;

        if (nums[0] < nums[nums.length - 1]) {
            result = Arrays.binarySearch(nums, 0, nums.length, target);
            return result >= 0 ? result : -1;

        }

        int kneeIndex = getKneeIndex(nums);

        if (target == nums[kneeIndex]) {
            return kneeIndex;
        }

        if (target > nums[kneeIndex] || target < nums[kneeIndex + 1]) {
            return -1;
        }

        if (target > nums[0]) {
            result = Arrays.binarySearch(nums, 1, kneeIndex, target);
        }

        if (target < nums[nums.length - 1]) {
            result = Arrays.binarySearch(nums, kneeIndex + 1, nums.length, target);
        }

        return result >= 0 ? result : -1;
    }

    public static int getKneeIndex(int[] nums) {
        int i = 0, j = nums.length - 1, m = -1;

        while (i <= j) {
            m = (i + j) / 2;

            if (((m - 1) < 0 || nums[m - 1] < nums[m]) && ((m + 1) >= nums.length || nums[m + 1] < nums[m])) {
                return m;
            }

            if (nums[m] >= nums[i]) {
                i = m + 1;
            } else if (nums[m] < nums[j]) {
                j = m - 1;
            }
        }

        return m;
    }

    public static void main(String[] args) {
//        System.out.println(search_1(new int[]{4,5,6,7,0,1,2}, 3));
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 3));
//        System.out.println(getKneeIndex(new int[]{4,5,1,2,3}));
    }
}
