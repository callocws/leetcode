package leetcode._61;

import leetcode.ListNode;

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int size = 0;
        ListNode dummy = new ListNode(0, head), p, last = null;
        for (p = head; p != null; size++, p = p.next) {
            last = p;
        }
        k = size - (k % size);

        p = dummy;
        for (int i = 0; i < k; i++) {
            p = p.next;
        }

        last.next = dummy.next;
        dummy.next = p.next;
        p.next = null;
        return dummy.next;
    }
}
