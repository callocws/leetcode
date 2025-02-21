package leetcode._92;

import leetcode.ListNode;

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(), p, q, t = dummy;
        dummy.next = head;
        p = q = null;
        for (int i = 0; t != null; i++, t = t.next) {
            if (i == left - 1) {
                p = t;
            }
            if (i == right) {
                q = t.next;
            }
        }
        t = p.next;
        p.next = reverse(t, q);
        t.next = q;
        return dummy.next;
    }

    ListNode reverse(ListNode start, ListNode end) {
        if (start.next == end) {
            return start;
        }
        ListNode head = reverse(start.next, end);
        ListNode p = start.next;
        p.next = start;
        start.next = null;
        return head;
    }
}
