package com.paul.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BSTSequences {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> BSTSequences(TreeNode root) {
        if (root == null) {
            return Arrays.asList(new ArrayList<>());
        }

        List<List<Integer>> leftResult = null, rightResult = null, result = new ArrayList<>();

        if (root.left == null && root.right == null) {
            return Arrays.asList(Arrays.asList(root.val));
        }

        if (root.left != null) {
            leftResult = BSTSequences(root.left);
        }

        if (root.right != null) {
            rightResult = BSTSequences(root.right);
        }

        if (leftResult == null) {
            for (List<Integer> right : rightResult) {
                List<Integer> inner = new ArrayList<>();
                inner.add(root.val);
                inner.addAll(right);
                result.add(inner);
            }
        } else if (rightResult == null) {
            for (List<Integer> left : leftResult) {
                List<Integer> inner = new ArrayList<>();
                inner.add(root.val);
                inner.addAll(left);
                result.add(inner);
            }
        } else {
            for (List<Integer> left : leftResult) {
                for (List<Integer> right : rightResult) {
                    List<Integer> inner = new ArrayList<>();
                    inner.add(root.val);
                    inner.addAll(left);
                    inner.addAll(right);
                    result.add(inner);
                }
            }

            for (List<Integer> right : rightResult) {
                for (List<Integer> left : leftResult) {
                    List<Integer> inner = new ArrayList<>();
                    inner.add(root.val);
                    inner.addAll(right);
                    inner.addAll(left);
                    result.add(inner);
                }
            }
        }

        return result;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode left1 = new TreeNode(4);
        TreeNode left2 = new TreeNode(5);
        TreeNode right = new TreeNode(3);
        TreeNode right1 = new TreeNode(6);
        TreeNode right2 = new TreeNode(7);

        root.left = left;
        left.left = left1;
        left1.right = left2;
        root.right = right;
        right.right = right1;
        right.left = right2;

        System.out.println(new BSTSequences().BSTSequences(root));


    }
}
