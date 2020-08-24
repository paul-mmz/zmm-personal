package com.paul.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Trap {

    public static int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }

        int waters = 0;

        int[] twoMaxIndex = findTwoMaxIndex(height);

        for (int i = twoMaxIndex[0] + 1; i < twoMaxIndex[1]; ++i) {
            waters += (height[twoMaxIndex[0]] - height[i]);
        }

        int left = -1, right = twoMaxIndex[0];

        while (right > 0) {
            left = findMaxIndex(height, 0, right);
            for (int i = left + 1; i < right; ++i) {
                waters += (height[left] - height[i]);
            }

            right = left;
        }

        left = twoMaxIndex[1];

        while (left < height.length - 1) {
            right = findMaxIndex(height, left + 1, height.length);
            for (int i = left + 1; i < right; ++i) {
                waters += (height[right] - height[i]);
            }

            left = right;
        }

        return waters;
    }


    public static int[] findTwoMaxIndex(int[] height) {
        int[] twoMaxInxex = new int[2];
        Arrays.fill(twoMaxInxex, -1);
        int firstMax = -1, secondMax = -1;

        for (int i = 0; i < height.length; ++i) {
            if (secondMax < height[i]) {
                firstMax = secondMax;
                twoMaxInxex[0] = twoMaxInxex[1];

                secondMax = height[i];
                twoMaxInxex[1] = i;
            }
        }

        return twoMaxInxex;
    }

    public static int findMaxIndex(int[] height, int startIndex, int endIndex) {
        int maxIndex = -1, maxNum = -1;

        for (int i = startIndex; i < endIndex; ++i) {
            if (height[i] > maxNum) {
                maxNum = height[i];
                maxIndex = i;
            }
        }

        return maxIndex;
    }

    public static int trap_findEveryIndexWater(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }

        int water = 0;

        for (int i = 1; i < height.length - 1; ++i) {
            int leftMax = 0, rightMax = 0;
            for (int j = i - 1; j >= 0; --j) {
                leftMax = Math.max(leftMax, height[j]);
            }

            for (int j = i + 1; j < height.length; ++j) {
                rightMax = Math.max(rightMax, height[j]);
            }

            int waterTemp = Math.min(leftMax, rightMax) - height[i];
            water += waterTemp > 0 ? waterTemp : 0;
        }

        return water;
    }

    public static int trap_findEveryIndexWater_2(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }

        int water = 0;
        int tempWater = 0;

        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        leftMax[0] = height[0];
        for (int i = 1; i < height.length; ++i) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; --i) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        for (int i = 1; i < height.length - 1; ++i) {
            tempWater = Math.min(leftMax[i], rightMax[i]) - height[i];
            water += (tempWater > 0 ? tempWater : 0);
        }

        return water;
    }

    public static int trap_stack(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }

        int water = 0;
        int wallIndex = 0;
        int distance = 0;

        Stack<Integer> wallStack = new Stack<>();

        for (int i = 0; i < height.length; ++i) {
            while (!wallStack.isEmpty() && height[i] > height[wallStack.peek()]) {
                wallIndex = wallStack.pop();

                if (wallStack.isEmpty()) {
                    break;
                }

                distance = i - wallStack.peek() - 1;

                water += (Math.min(height[i], height[wallStack.peek()]) - height[wallIndex]) * distance;
            }

            wallStack.push(i);
        }

        return water;
    }

    public static int trap_twoPointer(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }

        int water = 0;
        int maxWallIndex = 0;

        for (int i = 1; i < height.length; ++i) {
            if (height[i] > height[maxWallIndex]) {
                maxWallIndex = i;
            }
        }

        int leftMaxIndex = 0;
        for (int i = 1; i < maxWallIndex; ++i) {
            if (height[i] > height[leftMaxIndex]) {
                leftMaxIndex = i;
                continue;
            }

            water += height[leftMaxIndex] - height[i];
        }

        int rightMaxIndex = height.length - 1;
        for (int i = height.length - 2; i > maxWallIndex; --i) {
            if (height[i] > height[rightMaxIndex]) {
                rightMaxIndex = i;
                continue;
            }

            water += height[rightMaxIndex] - height[i];
        }

        return water;
    }

    public static int trap_twoPointer_1(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }

        int water = 0;
        int leftMaxIndex = 0, rightMaxIndex = height.length - 1;
        int left = 0, right = height.length - 1;

        while (left <= right) {
            if (height[left] < height[right]) {
                if (height[left] > height[leftMaxIndex]) {
                    leftMaxIndex = left;
                } else {
                    water += height[leftMaxIndex] - height[left];
                }

                ++left;
            } else {
                if (height[right] > height[rightMaxIndex]) {
                    rightMaxIndex = right;
                } else {
                    water += height[rightMaxIndex] - height[right];
                }

                --right;
            }
        }

        return water;
    }


    public static void main(String[] args) {
//        System.out.println(findAllWall(new int[]{5,2,1,2,1,5}));

        System.out.println(trap_twoPointer_1(new int[]{5, 2, 1, 2, 1, 5}));
        System.out.println(trap_twoPointer_1(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(trap_twoPointer_1(new int[]{0, 2, 0}));
        System.out.println(trap_twoPointer_1(new int[]{4,2,0,3,2,5}));

    }

}
