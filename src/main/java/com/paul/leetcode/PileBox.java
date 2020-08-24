package com.paul.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/**
 * @author zmm233489
 * @date 2020/7/12
 */
public class PileBox {

    public int pileBox(int[][] box) {
        if (Objects.isNull(box) || box.length == 0) {
            return 0;
        }

        if (box.length == 1) {
            return box[0][2];
        }

        Arrays.sort(box, new Comparator<int[]>() {
            @Override
            public int compare(int[] box1, int[] box2) {
                return box1[0] == box2[0] ? (box1[1] == box2[1] ? Integer.compare(box2[2], box1[2]) : Integer.compare(box2[1], box1[1])) : Integer.compare(box1[0], box2[0]);
            }
        });

        int[] dp_sumHeight = new int[box.length];

        // 第i个元素表示以i结尾的堆起来的箱子的的height的最大和
        dp_sumHeight[0] = box[0][2];
        int maxSumHeight = dp_sumHeight[0];

        for (int i = 1; i < box.length; ++i) {

            dp_sumHeight[i] = box[i][2];

            for (int j = 0; j< i; ++j) {
                if (box[i][1] > box[j][1] && box[i][2] > box[j][2]) {
                    dp_sumHeight[i] = Math.max(dp_sumHeight[i], dp_sumHeight[j] + box[i][2]);
                }
            }

            maxSumHeight = Math.max(maxSumHeight, dp_sumHeight[i]);
        }

        return maxSumHeight;
    }

    private int[][] memo, box;
    private int len;

    public int pileBox_1(int[][] box) {
        len = box.length;

        Arrays.sort(box, (a, b) -> a[0] == b[0] ? a[1] == b[1] ? b[2] - a[2] : b[1] - a[1] : a[0] - b[0]);

        this.box = box;
        this.memo = new int[len + 1][len];

        for (int[] l : memo) {
            Arrays.fill(l, -1);
        }

        return dfs(-1, 0, 0, 0);
    }

    private int dfs(int pre_idx, int cur_idx, int depth_bound, int height_bound) {
        if (cur_idx == len) {
            return 0;
        }

        if (memo[pre_idx + 1][cur_idx] >= 0) {
            return memo[pre_idx + 1][cur_idx];
        }

        int taken = 0;

        if (pre_idx < 0 || (box[cur_idx][1] > depth_bound && box[cur_idx][2] > height_bound)) {
            taken = box[cur_idx][2] + dfs(cur_idx, cur_idx + 1, box[cur_idx][1], box[cur_idx][2]);
        }

        int not_taken = dfs(pre_idx, cur_idx + 1, depth_bound, height_bound);

        return memo[pre_idx + 1][cur_idx] = Math.max(taken, not_taken);
    }

    public static void main(String[] args) {
        System.out.println(new PileBox().pileBox(new int[][]{{1,1,1},{2,3,4},{2,6,7},{3,4,5}}));
    }
}
