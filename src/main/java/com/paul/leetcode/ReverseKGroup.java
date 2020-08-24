package com.paul.leetcode;

import java.util.Objects;

/**
 * @author zmm233489
 * @date 2020/8/23
 */
public class ReverseKGroup {

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) { val = x; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (Objects.isNull(head) || Objects.isNull(head.next) || k == 1) {
            return head;
        }

        ListNode p = head, q = p, qNext = null, preEnd = null;
        int nodeCount = 0;

        for (nodeCount = 1; q.next != null && nodeCount < k; ++nodeCount) {
            q = q.next;
        }

        if (nodeCount < k) {
            return head;
        }

        qNext = q.next;
        head = q;
        preEnd = p;

        reverseCertainNodes(p, q);

        while (qNext != null) {
            p = qNext;
            q = qNext;

            for (nodeCount = 1; q.next != null && nodeCount < k; ++nodeCount) {
                q = q.next;
            }

            if (nodeCount < k) {
                preEnd.next = p;
                return head;
            }

            qNext = q.next;

            reverseCertainNodes(p, q);

            preEnd.next = q;
            preEnd = p;
        }

        return head;
    }

    private void reverseCertainNodes(ListNode p, ListNode q) {
        ListNode first = p, second = first.next, temp = null;

        while (first != q) {
            temp = second.next;
            second.next = first;

            first = second;
            second = temp;
        }

        p.next = null;
    }

    public ListNode reverseKGroup_dummy(ListNode head, int k) {
        if (Objects.isNull(head) || Objects.isNull(head.next) || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode p, q;
        ListNode qNext = head, preEnd = dummy;

        while (qNext != null) {
            p = qNext;
            q = qNext;

            for (int i = 1; i < k; ++i) {
                q = q.next;

                if (q == null) {
                    preEnd.next = p;
                    return dummy.next;
                }
            }

            qNext = q.next;

            reverseCertainNodes(p, q);

            preEnd.next = q;
            preEnd = p;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1), p = head, q;
        for (int i = 2; i < 6; ++i) {
            q = new ListNode(i);
            p.next = q;
            p = q;
        }

        ListNode newHead = new ReverseKGroup().reverseKGroup_dummy(head, 5);
        System.out.println(newHead);
    }
}
