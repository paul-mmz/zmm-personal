package com.paul.leetcode;

public class MaxAreaOfIsland {
    public static int maxAreaOfIsland(int[][] grid) {
        if (grid == null) {
            return 0;
        }

        if (grid.length == 1 && grid[0].length == 1) {
            return grid[0][0];
        }

        int maxArea = 0;

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                maxArea = Math.max(maxArea, currentIslandArea(grid, i, j));
            }
        }

        return maxArea;
    }

    public static int currentIslandArea(int[][] grid, int i, int j) {
        if (i < grid.length && i >= 0 && j < grid[i].length && j >= 0 && grid[i][j] == 1) {
            grid[i][j] = 0;

            return 1 + currentIslandArea(grid, i - 1, j) + currentIslandArea(grid, i + 1, j) + currentIslandArea(grid, i, j - 1) + currentIslandArea(grid, i, j + 1);
        }

        return 0;
    }

    public static void main(String[] args) {

        System.out.println(maxAreaOfIsland(new int[][]{
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}}));

//        System.out.println(maxAreaOfIsland(new int[][]{
//                {0,0,1},
//                {0,0,0},
//                {0,1,1}}));

    }
}