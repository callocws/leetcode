package leetcode._2;

import leetcode.ListNode;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1, q = l2, t, previous, head;
        int carry = 0;
        for (previous = head = new ListNode(); carry > 0 || p != null || q != null; ) {
            t = new ListNode();
            if (p != null) {
                t.val += p.val;
                p = p.next;
            }
            if (q != null) {
                t.val += q.val;
                q = q.next;
            }
            t.val += carry;
            carry = t.val / 10;
            t.val %= 10;

            previous.next = t;
            previous = t;
        }
        return head.next;
    }
}
