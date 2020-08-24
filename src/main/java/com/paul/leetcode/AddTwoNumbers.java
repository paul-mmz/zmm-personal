package com.paul.leetcode;

public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        ListNode n1 = l1, n2 = l2, newRoot = new ListNode(-1), p = newRoot, q = null;
        int carry = 0, sum = 0;

        while (n1 != null && n2 != null) {
            sum = n1.val + n2.val + carry;
            q = new ListNode(sum % 10);
            carry = sum / 10;

            p.next = q;
            p = q;
            n1 = n1.next;
            n2 = n2.next;
        }

        n1 = n1 != null ? n1 : n2;

        while (n1 != null) {
            sum = n1.val + carry;
            q = new ListNode(sum % 10);
            carry = sum / 10;

            p.next = q;
            p = q;
            n1 = n1.next;
        }

        if (carry > 0) {
            q = new ListNode(carry);
            p.next = q;
        }

        return newRoot.next;
    }

    public static void main(String[] args) {
    }
}
