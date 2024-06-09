package leetcode._21;

import leetcode.ListNode;

class Solution {
    public ListNode mergeTwoLists(ListNode p, ListNode q) {
        ListNode h = new ListNode(), t;
        if(p == null) {
            h.next = q;
        }
        if(q == null) {
            h.next = p;
        }
        for(t = h; p != null && q != null;) {
            if(p.val < q.val) {
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
        }
        if(q == null) {
            t.next = p;
        }
        return h.next;
    }
}

class Solution1 {
    public ListNode mergeTwoLists(ListNode p, ListNode q) {
        if(p == null || q == null) {
            return p == null ? q : p;
        }
        if(p.val < q.val) {
            p.next = mergeTwoLists(p.next, q);
            return p;
        } else {
            q.next = mergeTwoLists(q.next, p);
            return q;
        }
    }
}