package leetcode._23;

import leetcode.ListNode;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode l = new ListNode();
        for(int i = 0; i < lists.length; i++) {
            ListNode h1 = l.next, h2 = lists[i], p, q, t;
            for(p = h1, q = h2, t = l; p != null && q != null;) {
                if(p.val <= q.val) {
                    t.next = p;
                    t = p;
                    p = p.next;
                } else {
                    t.next = q;
                    t = q;
                    q = q.next;
                }
            }
            if(p == null) {
                t.next = q;
            } else {
                t.next = p;
            }
        }
        return l.next;
    }
}