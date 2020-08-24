package com.paul.leetcode;

import javax.validation.constraints.Max;
import java.util.Objects;

public class MaxScoreSightseeingPair {
    public int maxScoreSightseeingPair(int[] A) {
        if (Objects.isNull(A) || A.length < 2) {
            return 0;
        }

        int maxI = A[0], maxValue = 0;

        for (int i = 1; i < A.length; ++i) {
            maxValue = Math.max(maxValue, A[i] - i + maxI);
            maxI = Math.max(maxI, A[i] + i);
        }

        return maxValue;
    }

    public static void main(String[] args) {
        System.out.println(
                new MaxScoreSightseeingPair().
                maxScoreSightseeingPair(new int[]{8,1,5,2,6}));
    }
}
