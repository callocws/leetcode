package leetcode._21;

import leetcode.ListNode;

class Solution {
    public ListNode mergeTwoLists(ListNode p, ListNode q) {
        ListNode h = new ListNode(), t;
        for (t = h; p != null || q != null; ) {
            if (p == null) {
                t.next = q;
                break;
            } else if (q == null) {
                t.next = p;
                break;
            }
            if (p.val < q.val) {
                t.next = p;
                t = p;
                p = p.next;
            } else {
                t.next = q;
                t = q;
                q = q.next;
            }
        }
        return h.next;
    }
}

class Solution1 {
    public ListNode mergeTwoLists(ListNode p, ListNode q) {
        if (p == null || q == null) {
            return p == null ? q : p;
        }
        if (p.val < q.val) {
            p.next = mergeTwoLists(p.next, q);
            return p;
        } else {
            q.next = mergeTwoLists(q.next, p);
            return q;
        }
    }
}
