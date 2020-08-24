package com.paul.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author zmm233489
 * @date 2020/8/22
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        if (Objects.isNull(nums) || nums.length < 2) {
            return null;
        }

        int[][] sortedNums = new int[nums.length][2];

        for (int i = 0; i < nums.length; ++i) {
            sortedNums[i] = new int[]{nums[i], i};
        }

        Arrays.sort(sortedNums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        int left = 0, right = sortedNums.length - 1, currentsum = 0;

        while(left < right) {
            currentsum = sortedNums[left][0] + sortedNums[right][0];
            if (currentsum == target) {
                return new int[]{sortedNums[left][1], sortedNums[right][1]};
            }

            if (currentsum > target) {
                --right;
            } else {
                ++left;
            }
        }

        return null;
    }

    public int[] twoSum_oneScan(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] twoSum_toScan(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        final int[] ints = new TwoSum().twoSum(new int[] {0, 4, 3, 0}, 0);
        System.out.println(ints[0]);
        System.out.println(ints[1]);
    }
}
