package com.paul.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zmm233489
 * @date 2021/6/20
 * nums - 递增排序的候选数组
 * t - 目标值
 * f(i, t)表示在 nums 从i - 0下标的候选数字中，所以可以相加 = t的数字组合；
 * f(i, t) = 1. t < nums[i] -> f(i - 1, t);
 *           2. t >= nums[i]
 *              2.1 t - nums[i] < num[i] -> [f(i - 1, t - nums[i]) + num[i]] + f(i - 1, t);
 *              2.2 t - nums[i] >= num[i] -> [f(i, t - nums[i]) + num[i]] + f(i - 1, t);
 * 简化如下：
 * f(i, t) = 1. t < nums[i] -> f(i - 1, t);
 *           2. t < 2 * num[i] -> [f(i - 1, t - nums[i]) + num[i]] + f(i - 1, t)
 *           3. t >= 2 * nums[i] -> [f(i, t - nums[i]) + num[i]] + f(i - 1, t)
 *
 * 终止条件：
 * 1. t == 0 -> 有解
 * 2. i < 0 || t < 0 - 无解
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return null;
        }

        Arrays.sort(candidates);
        List<List<Integer>> result = combinationInSortedArray(candidates, candidates.length - 1, target);
        return result == null ? new LinkedList<>() : result;
    }

    public List<List<Integer>> combinationInSortedArray(int[] candidates, int endIndex, int target) {
        if (target == 0) {
            return new LinkedList<>();
        }
        if (target < 0 || endIndex < 0) {
            return null;
        }

        List<List<Integer>> result = combinationInSortedArray(candidates, endIndex - 1, target);

        List<List<Integer>> ret = null;
        if (target < 2 * candidates[endIndex]) {
            ret = combinationInSortedArray(candidates, endIndex - 1, target - candidates[endIndex]);
        } else if (target >= 2 * candidates[endIndex]) {
            ret = combinationInSortedArray(candidates, endIndex, target - candidates[endIndex]);
        }

        if (ret == null) {
            return result;
        }

        if (ret.size() == 0) {
            LinkedList<Integer> iret = new LinkedList<>();
            iret.addLast(candidates[endIndex]);
            ret.add(iret);
        } else {
            for (List<Integer> iret : ret) {
                ((LinkedList) iret).addLast(candidates[endIndex]);
            }
        }

        if (result == null) {
            return ret;
        } else {
            result.addAll(ret);
            return result;
        }
    }

    public static void main(String[] args) {

        int[] candidates = {3, 6, 7, 2};

        CombinationSum combinationSum = new CombinationSum();
        System.out.println(combinationSum.combinationSum(candidates, 7));
    }
}
