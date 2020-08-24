package com.paul.leetcode;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author zmm233489
 * @date 2020/8/20
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        if (Objects.isNull(nums)) {
            return 0;
        }

        Arrays.sort(nums);

        int left = 0, right = 0;
        int minInterval = Integer.MAX_VALUE;
        int currentInterval = 0;

        for (int i = 1; i < nums.length - 1; ++i) {
            int innerInterval = nums[i] - target;

            left = 0;
            right = nums.length - 1;

            while (left < i && right > i) {
                currentInterval = nums[left] + nums[right] + innerInterval;

                if (currentInterval == 0) {
                    return currentInterval + target;
                }

                if (Math.abs(currentInterval) < Math.abs(minInterval)) {
                    minInterval = currentInterval;
                }

                if (currentInterval < 0) {
                    ++left;
                } else {
                    --right;
                }
            }
        }

        return minInterval + target;
    }

    public static void main(String[] args) {
        System.out.println(new ThreeSumClosest().threeSumClosest(new int[]{0,2,1,-3}, 1));
    }
}
