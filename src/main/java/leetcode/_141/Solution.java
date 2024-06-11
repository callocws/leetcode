package leetcode._141;

import leetcode.ListNode;

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode p, q;
        for(p = q = head; p != null; ) {
            p = p.next;
            q = q.next;
            if(p == null) {
                return false;
            }
            p = p.next;
            if(p == q) {
                return true;
            }
        }
        return false;
    }
}