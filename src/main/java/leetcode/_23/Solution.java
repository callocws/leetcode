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

class Solution1 {

    ListNode partition(ListNode[] lists, int i, int j) {
        if(i >= j) {
            return j < 0 ? null : lists[j];
        }
        int m = (i + j) / 2;
        ListNode l = partition(lists, i, m);
        ListNode r = partition(lists, m + 1, j);
        return merge(l, r);
    }

    ListNode merge(ListNode p, ListNode q) {
        if(p == null || q == null) {
            return p == null ? q : p;
        }
        ListNode t;
        if(p.val < q.val) {
            t = merge(p.next, q);
            p.next = t;
            return p;
        } else {
            t = merge(p, q.next);
            q.next = t;
            return q;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        return partition(lists, 0, lists.length - 1);
    }
}