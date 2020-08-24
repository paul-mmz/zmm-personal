package com.paul.leetcode;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static ListNode createList(int[] nums) {
        ListNode root = new ListNode(nums[0]);
        ListNode q = root;

        for (int i = 1; i < nums.length; ++i) {
            q.next = new ListNode(nums[i]);
            q = q.next;
        }

        return root;
    }
}
