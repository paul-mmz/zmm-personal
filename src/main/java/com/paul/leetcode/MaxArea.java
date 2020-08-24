package com.paul.leetcode;

import java.util.Objects;

/**
 * @author zmm233489
 * @date 2020/8/16
 */
public class MaxArea {

    public int maxArea_bruthForce(int[] height) {
        if (Objects.isNull(height) || height.length < 2) {
            return 0;
        }

        if (height.length == 2) {
            return Math.min(height[0], height[1]);
        }

        int maxArea = 0;

        for (int i = 0; i < height.length - 1; ++i) {
            for (int j = i + 1; j < height.length; ++j) {
                maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
            }
        }

        return maxArea;
    }

    public int maxArea_twoPointer(int[] height) {
        if (Objects.isNull(height) || height.length < 2) {
            return 0;
        }

        if (height.length == 2) {
            return Math.min(height[0], height[1]);
        }

        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = height.length - 1;
        int maxArea = Math.min(height[leftMax], height[rightMax]) * (rightMax - leftMax);

        while (left < right) {
            if (height[leftMax] < height[rightMax]) {
                ++left;

                if (height[left] > height[leftMax]) {
                    leftMax = left;
                    maxArea = Math.max(maxArea, Math.min(height[leftMax], height[rightMax]) * (rightMax - leftMax));
                }
            } else {
                --right;

                if (height[right] > height[rightMax]) {
                    rightMax = right;
                    maxArea = Math.max(maxArea, Math.min(height[leftMax], height[rightMax]) * (rightMax - leftMax));
                }
            }
        }

        return maxArea;
    }

    public int maxArea_official(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] <= height[r]) {
                ++l;
            }
            else {
                --r;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new MaxArea().maxArea_twoPointer(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
