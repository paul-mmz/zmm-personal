package com.paul.leetcode;

public class MergeKLists {

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        if (lists.length == 1) {
            return lists[0];
        }

        ListNode current = lists[0];

        for (int i = 1; i < lists.length; ++i) {
            current = mergeTwoList(current, lists[i]);
        }

        return current;
    }

    public static ListNode mergeKLists_split(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        if (lists.length == 1) {
            return lists[0];
        }

        int step = 1;
        while (step < lists.length) {
            for (int i = 0; i < lists.length - step; i += step * 2) {
                lists[i] = mergeTwoList(lists[i], lists[i + step]);
            }

            step = step * 2;
        }

        return lists[0];
    }

    public static ListNode mergeTwoList(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        ListNode p = l1, q = l2, temp = null;

        while (p != null && q != null) {
            if (p.val < q.val) {
                while (p.next != null && p.next.val < q.val) {
                    p = p.next;
                }

                temp = p.next;
                p.next = q;
                p = temp;
            } else {
                while (q.next != null && q.next.val <= p.val) {
                    q = q.next;
                }

                temp = q.next;
                q.next = p;
                q = temp;
            }
        }

        if (l1.val < l2.val) {
            return l1;
        } else {
            return l2;
        }
    }


    public static void main(String[] args) {
        final ListNode[] listNodes = {
                ListNode.createList(new int[]{1, 4, 5}),
                ListNode.createList(new int[]{1, 3, 4}),
                ListNode.createList(new int[]{2, 6})};

        ListNode listNode = mergeKLists_split(listNodes);

        System.out.println(listNode);
    }
}
