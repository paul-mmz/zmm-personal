package com.paul.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class FindCircleNum {

    public static int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) {
            return 0;
        }

        int[] visited = new int[M.length];
        int count = 0;

        for (int i = 0; i < M.length; ++i) {
            if (visited[i] == 1)
                continue;

//            dfs(M, i, visited);
            bfs(M, i, visited);
            ++count;
        }

        return count;
    }

    public static void dfs(int[][] M, int index, int[] visited) {
        visited[index] = 1;

        for (int i = 0; i < M.length; ++i) {
            if (M[index][i] == 1 && visited[i] != 1 && index != i) {
                dfs(M, i, visited);
            }
        }
    }

    public static void bfs(int[][] M, int index, int[] visited) {
        Deque<Integer> deque = new ArrayDeque<>();

        deque.addLast(index);

        while (!deque.isEmpty()) {
            Integer people = deque.pollFirst();

            visited[people] = 1;

            for (int i = 0; i < M.length; ++i) {
                if (M[people][i] == 1 && visited[i] != 1) {
                    deque.addLast(i);
                }
            }
        }
    }


    public static int findCircleNum_1(int[][] M) {
        if (M == null || M.length == 0) {
            return 0;
        }

        int[] parent = new int[M.length];
        Arrays.fill(parent, -1);

        for (int i = 0; i < M.length; ++i) {
            for (int j = 0; j < M.length; ++j) {
                if (i != j && M[i][j] == 1) {
                    union(parent, i, j);
                }
            }
        }

        int count = 0;

        for (int i = 0; i < parent.length; ++i) {
            if (parent[i] == -1)
                ++count;
        }

        return count;
    }

    public static void union(int[] parent, int i, int j) {
        int iRoot = findFriRoot(parent, i);
        int jRoot = findFriRoot(parent, j);

        if (iRoot != jRoot) {
            parent[iRoot] = jRoot;
        }
    }

    public static int findFriRoot(int[] parent, int i) {
        while (parent[i] != -1) {
            i = parent[i];
        }

        return i;

    }


    public static void main(String[] args) {
        int[][] M =
                       {{1,0,0,0,0,0,0,0,0,1,0,0,0,0,0},
                        {0,1,0,1,0,0,0,0,0,0,0,0,0,1,0},
                        {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
                        {0,1,0,1,0,0,0,1,0,0,0,1,0,0,0},
                        {0,0,0,0,1,0,0,0,0,0,0,0,1,0,0},
                        {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
                        {0,0,0,1,0,0,0,1,1,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,1,1,0,0,0,0,0,0},
                        {1,0,0,0,0,0,0,0,0,1,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0,1,0,0,0,0},
                        {0,0,0,1,0,0,0,0,0,0,0,1,0,0,0},
                        {0,0,0,0,1,0,0,0,0,0,0,0,1,0,0},
                        {0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},
                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,1}};

        System.out.println(findCircleNum(M));
        System.out.println(findCircleNum_1(M));
    }
}
