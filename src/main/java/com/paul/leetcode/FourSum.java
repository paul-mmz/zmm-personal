package com.paul.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author zmm233489
 * @date 2020/8/23
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (Objects.isNull(nums) || nums.length < 4) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);

        List<List<Integer>> re = new ArrayList<>();

        int left = 0, right = 0, innerTarget = 0, innerSum = 0;

        for (int i = 0; i < nums.length - 3; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            if (target >= 0 && nums[i] > target) {
                continue;
            }

            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                continue;
            }

            if (nums[i] + nums[nums.length - 3] + nums[nums.length - 2] + nums[nums.length - 1] < target) {
                continue;
            }

            for (int j = i + 1; j < nums.length - 2; ++j) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    continue;
                }

                if (nums[i] + nums[j] + nums[nums.length - 2] + nums[nums.length - 1] < target) {
                    continue;
                }

                innerTarget = target - nums[i] - nums[j];

                left = j + 1;
                right = nums.length - 1;

                while (left < right) {
                    if (left > j + 1 && nums[left] == nums[left - 1]) {
                        ++left;
                        continue;
                    }

                    innerSum = nums[left] + nums[right];

                    if (innerSum == innerTarget) {
                        re.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        ++left;
                        --right;
                    } else if (innerSum < innerTarget) {
                        ++left;
                    } else {
                        --right;
                    }
                }
            }
        }

        return re;
    }
}
