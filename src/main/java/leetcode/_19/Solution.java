package leetcode._19;

import leetcode.ListNode;

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p, q, k = new ListNode();
        int i = 0;
        for(p = q = k, k.next = head; p != null; ) {
            if(i++ > n) {
                q = q.next;
            }
            p = p.next;
        }
        q.next = q.next.next;
        return k.next;
    }
}