package com.paul.leetcode;

public class ReverseList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public ListNode reverseList_iter(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = null, q = head, r;
        while (q != null) {
            r = q.next;
            q.next = p;
            p = q;
            q = r;
        }

        return p;
    }
}
