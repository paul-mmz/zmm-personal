package com.paul.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author zmm233489
 * @date 2021/6/20
 *
 * nums - 递增排序的候选数组（数组里的数字不允许重复使用）
 * t - 目标值
 * f(i, t)表示在 nums 从i - 0下标的候选数字中，所以可以相加 = t的数字组合；
 * f(i, t) = 1. t < nums[i] -> f(i - 1, t);
 *           2. t >= nums[i] -> [f(i - 1, t - nums[i]) + num[i]] + f(i - 1, t)
 *
 * 终止条件：
 * 1. t == 0 -> 保存解
 * 2. i < 0 - 停止
 */
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return null;
        }

        Arrays.sort(candidates);
        Set<List<Integer>> result = new HashSet<>();
        LinkedList<Integer> comb = new LinkedList<>();
        combinationInSortedArray(candidates, candidates.length - 1, target, comb, result);
        return new ArrayList<>(result);
    }

    public void combinationInSortedArray(int[] candidates, int endIndex, int target, LinkedList<Integer> comb, Set<List<Integer>> result) {
        if (target == 0) {
            result.add(new LinkedList<>(comb));
            return;
        }

        if (endIndex < 0) {
            return;
        }

        if (target >= candidates[endIndex]) {
            comb.addFirst(candidates[endIndex]);
            combinationInSortedArray(candidates, endIndex - 1,target - candidates[endIndex], comb, result);
            comb.removeFirst();
        }
        combinationInSortedArray(candidates, endIndex - 1, target, comb, result);
    }

    public List<List<Integer>> combinationSum2_1(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return null;
        }

        Arrays.sort(candidates);
        Map<Integer, Integer> digitCnt = new HashMap<>();
        for (int i = 0; i < candidates.length; ++i) {
            digitCnt.put(candidates[i], digitCnt.getOrDefault(candidates[i], 0) + 1);
        }
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> comb = new LinkedList<>();
        combinationInSortedArray_1(candidates, candidates.length - 1, target, digitCnt, comb, result);
        return result;
    }

    public void combinationInSortedArray_1(int[] candidates, int endIndex, int target,
        Map<Integer, Integer> digitCnt, LinkedList<Integer> comb, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new LinkedList<>(comb));
            return;
        }

        if (endIndex < 0) {
            return;
        }

        for (int i = 1; i <= digitCnt.get(candidates[endIndex]); ++i) {
            if (target >= candidates[endIndex] * i) {
                for (int j = 0; j < i; ++j) {
                    comb.addFirst(candidates[endIndex]);
                }
                combinationInSortedArray_1(candidates, endIndex - digitCnt.get(candidates[endIndex]),target - (candidates[endIndex] * i), digitCnt, comb, result);
                for (int j = 0; j < i; ++j) {
                    comb.removeFirst();
                }
            }
        }
        combinationInSortedArray_1(candidates, endIndex - digitCnt.get(candidates[endIndex]), target, digitCnt, comb, result);
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        CombinationSum2 combinationSum2 = new CombinationSum2();
        List<List<Integer>> lists = combinationSum2.combinationSum2_1(candidates, 8);
        System.out.println(lists);
    }
}
