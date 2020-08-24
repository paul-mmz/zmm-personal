package com.paul.leetcode;

import java.util.Objects;

/**
 * @author zmm233489
 * @date 2020/7/15
 */
class NumArray {
    /**
     * 以数组保存线段树
     * 对于 n 长的原数组，需要 2 * n 长的线段树数组
     * segTreeArr 下标从 1 开始
     * 对于 segTreeArr 中 i 节点，2 * i 是其左节点，2 * i + 1 是其右节点
     */
    private int[] segTreeArr;

    /**
     * 原数组
     */
    private int[] metaNums;

    public NumArray(int[] nums) {

        metaNums = nums;

        if (Objects.isNull(metaNums)) {
            segTreeArr = new int[0];
            return;
        }

        segTreeArr = new int[metaNums.length * 2];

        for (int i = metaNums.length, j = 0; i < segTreeArr.length; ++i, ++j) {
            segTreeArr[i] = metaNums[j];
        }

        for (int i = metaNums.length - 1; i > 0; --i) {
            segTreeArr[i] = segTreeArr[2 * i] + segTreeArr[2 * i + 1];
        }
    }

    public void update(int i, int val) {
        metaNums[i] = val;

        i += metaNums.length;

        int oldVal = segTreeArr[i];
        segTreeArr[i] = val;
        i /= 2;

        while (i > 0) {
            segTreeArr[i] = segTreeArr[i] - oldVal + val;
            i /= 2;
        }
    }

    public int sumRange(int i, int j) {

        i += metaNums.length;
        j += metaNums.length;

        int sum = 0;
        while (i <= j) {
            // 如果 i 节点是左子树，j节点是右子树，则[i, j]这段序列的和最终对应一个完整的节点，只需要往上寻找到该节点即可

            // 如果 i 节点是右子树，则i节点往上的节点，无法直接使用；所以先把i节点的值加入到sum中
            // 同理如果 j 节点是左子树，则 j 节点往上的节点，无法直接使用；先把j接待的值加入到sum中
            if (i % 2 == 1) {
                sum += segTreeArr[i];
                ++i;
            }

            if (j % 2 == 0) {
                sum += segTreeArr[j];
                --j;
            }

            i /= 2;
            j /= 2;
        }

        return sum;
    }
}