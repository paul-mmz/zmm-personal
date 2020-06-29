package com.paul.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
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
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            result.add(new ArrayList<>());
            return result;
        }

        if (root.left == null && root.right == null) {
            return Arrays.asList(Arrays.asList(root.val));
        }

        List<List<Integer>> subR = null;

        List<List<Integer>> leftRest = BSTSequences(root.left), rightRest = BSTSequences(root.right);

        if (root.left == null) {
            subR = rightRest;
        } else if (root.right == null) {
            subR = leftRest;
        } else {
            subR = new ArrayList<>();
            for (List<Integer> leftR : leftRest) {
                for (List<Integer> rightR : rightRest) {
                    subR.addAll(fullMerge(leftR, rightR));
                }
            }
        }


        for (List<Integer> sub: subR) {
            List<Integer> newSub = new ArrayList<>();

            newSub.add(root.val);
            newSub.addAll(sub);

            result.add(newSub);
        }
        return result;
    }

    private List<List<Integer>> innerMerge(List<Integer> list1, int start1, List<Integer> list2, int start2) {
        if (list1 == null && list2 == null) {
            return new ArrayList<>();
        }

        if (list1 == null || start1 >= list1.size()) {
            return Arrays.asList(list2.subList(start2, list2.size()));
        }

        if (list2 == null || start2 >= list2.size()) {
            return Arrays.asList(list1.subList(start1, list1.size()));
        }

        List<List<Integer>> rest;

        if (start1 == list1.size() -1 || start2 == list2.size() - 1) {
            return start1 == list1.size() - 1 ? simpleMerge(list1.get(start1), list2.subList(start2, list2.size())) : simpleMerge(list2.get(start2), list1.subList(start1, list1.size()));
        }

        rest = new ArrayList<>();

        for (int i = start1; i <= list1.size(); ++i) {

            List<List<Integer>> subRests = innerMerge(list1, i, list2, start2 + 1);

            for (List<Integer> subRest : subRests) {
                List<Integer> irest = new ArrayList<>();
                partAddAll(irest, list1, start1, i);
                irest.add(list2.get(start2));
                irest.addAll(subRest);

                rest.add(irest);
            }
        }

        return rest;
    }

    private List<List<Integer>> simpleMerge(Integer only, List<Integer> beMergedList) {
        if (beMergedList == null || beMergedList.size() == 0) {
            return Arrays.asList(Arrays.asList(only));
        }

        List<List<Integer>> innerRest = new ArrayList<>();

        for (int i = 0; i <= beMergedList.size(); ++i) {
            List<Integer> irest = new ArrayList<>();

            partAddAll(irest, beMergedList, 0, i);
            irest.add(only);
            partAddAll(irest, beMergedList, i, beMergedList.size());

            innerRest.add(irest);
        }

        return innerRest;
    }

    public void partAddAll(List<Integer> addList, List<Integer> beAddedList, int start, int end) {
        for (int i = start; i < end; ++i) {
            addList.add(beAddedList.get(i));
        }
    }



    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> BSTSequences_1(TreeNode root) {
        if (root == null) {
            res.add(new LinkedList<>());
            return res;
        }

        LinkedList<Integer> path = new LinkedList<>();
        path.add(root.val);

        helper(root, new LinkedList<>(), path);

        return res;
    }

    public void helper(TreeNode root, LinkedList<TreeNode> queue, LinkedList<Integer> path){
        if (root == null) return;

        if (root.left != null) queue.add(root.left);
        if (root.right != null) queue.add(root.right);

        if (queue.isEmpty()) {
            res.add(new LinkedList<>(path));
            return;
        }

        int lens = queue.size();
        for (int i = 0; i < lens; i++){
            TreeNode cur = queue.get(i);
            queue.remove(i);
            path.add(cur.val);

            helper(cur, new LinkedList<>(queue), path);

            queue.add(i, cur);
            path.removeLast();
        }
    }

    public List<List<Integer>> fullMerge(List<Integer> list1, List<Integer> list2) {
        if (list1 == null && list2 == null) {
            return new ArrayList<>();
        }

        if (list1 == null) {
            return Arrays.asList(list2);
        } else if (list2 == null) {
            return Arrays.asList(list1);
        }

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> queue = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();

        queue.add(0);
        queue.add(1 + list1.size());

        partFullMerge(list1, list2, queue, result, path);

        return result;
    }

    private void partFullMerge(List<Integer> list1, List<Integer> list2, List<Integer> queue, List<List<Integer>> result, LinkedList<Integer> path) {
        if (queue == null || queue.size() == 0) {
            result.add(new LinkedList<>(path));
            return;
        }

        for (int i = 0; i < queue.size(); ++i) {
            Integer index = queue.get(i);
            queue.remove(i);

            if (index < list1.size()) {
                path.add(list1.get(index));
            } else {
                path.add(list2.get(index - 1 - list1.size()));
            }

            List<Integer> newQueue = new LinkedList<>(queue);
            if (index != list1.size() - 1 && index != list1.size() + list2.size()) {
                newQueue.add(index + 1);
            }

            partFullMerge(list1, list2, newQueue, result, path);

            queue.add(i, index);
            path.removeLast();
        }
    }


    public static void main(String[] args) {
//        TreeNode root = new TreeNode(5);
//        TreeNode left1 = new TreeNode(2);
//        TreeNode right1 = new TreeNode(8);
//        TreeNode left2 = new TreeNode(1);
//        TreeNode right2 = new TreeNode(3);
//        TreeNode left22 = new TreeNode(6);
//        TreeNode right3 = new TreeNode(4);
//        TreeNode right33 = new TreeNode(7);
//
//        root.left = left1;
//        root.right = right1;
//        left1.left = left2;
//        left1.right = right2;
//        right1.left = left22;
//        right2.right = right3;
//        left22.right = right33;

        TreeNode root = new TreeNode(5);
        TreeNode left1 = new TreeNode(2);
        TreeNode left2 = new TreeNode(1);
        TreeNode right2 = new TreeNode(3);
        TreeNode right3 = new TreeNode(4);

        root.left = left1;
        left1.left = left2;
        left1.right = right3;
        right3.right = right2;

        System.out.println(new BSTSequences().BSTSequences(root));

//        List<Integer> list1 = Arrays.asList(1,2,3);
//        List<Integer> list2 = Arrays.asList(4,5,6,7,8);
//
//        System.out.println(new BSTSequences().fullMerge(list1, list2));
//        System.out.println(new BSTSequences().innerMerge(list1, 0, list2, 0));


    }
}