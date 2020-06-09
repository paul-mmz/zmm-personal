package com.paul.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Trap {
//    public static int trap(int[] height) {
//        if (height == null || height.length <=2) {
//            return 0;
//        }
//
//        List<Integer> walls = findAllWall(height);
//
//        if (walls.size() < 2) {
//            return 0;
//        }
//
//        int waters = 0;
//
//        for (int i = 0; i < walls.size() - 1; ++i) {
//            int shortWallHeight = Math.min(height[walls.get(i)], height[walls.get(i + 1)]);
//
//            for (int j = walls.get(i) + 1; j < walls.get(i + 1); ++j) {
//                int water = shortWallHeight - height[j];
//                waters += water > 0 ? water : 0;
//            }
//        }
//
//        return waters;
//    }
//
//    public static List<Integer> findAllWall(int[] height) {
//        List<Integer> walls = new ArrayList<>();
//
//        for (int i = 0; i < height.length; ++i) {
//            int j = -1;
//            for (j = i + 1; j < height.length; ++j) {
//                if (height[j] != height[i]) {
//                    break;
//                }
//            }
//
//            j--;
//
//            if ((i - 1 < 0 || height[i - 1] < height[i]) && (j + 1 >= height.length || height[j + 1] < height[i])) {
//                walls.add(j);
//            }
//        }
//
//        List<Integer> resultWalls = new ArrayList<>();
//
//        resultWalls.add(walls.get(0));
//
//        for (int i = 1; i < walls.size() - 1; ++i) {
//            if (height[walls.get(i - 1)] > height[walls.get(i)] && height[walls.get(i + 1)] > height[walls.get(i)]) {
//                continue;
//            }
//
//            resultWalls.add(walls.get(i));
//        }
//
//        resultWalls.add(walls.get(walls.size() - 1));
//
//        return resultWalls;
//    }

    public static int trap(int[] height) {
        if (height == null || height.length <=2) {
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


    public static void main(String[] args) {

//        int[] height = {6, 4, 2, 0, 3, 2, 0, 3, 1, 4, 5, 3, 2, 7, 5, 3, 0, 1, 2, 1, 3, 4, 6, 8, 1, 3};
//        int[] twoMaxIndex = findTwoMaxIndex(height);
//        System.out.println(twoMaxIndex);
//        System.out.println(findMaxIndex(height, 0 , twoMaxIndex[0]));
//        System.out.println(findMaxIndex(height, twoMaxIndex[1] + 1, height.length));
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(trap(new int[]{4,2,0,3,2,4,3,4}));
        System.out.println(trap(new int[]{5, 2, 1, 2, 1, 5}));
        System.out.println(trap(new int[]{5,5,1,7,1,1,5,2,7,6}));
        System.out.println(trap(new int[]{6,4,2,0,3,2,0,3,1,4,5,3,2,7,5,3,0,1,2,1,3,4,6,8,1,3}));

    }

}