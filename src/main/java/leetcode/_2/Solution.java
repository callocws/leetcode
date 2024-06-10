package leetcode._2;

import leetcode.ListNode;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1, q = l2, t, k, h;
        int over = 0;
        for(k = h = new ListNode(); over > 0 || p != null || q != null; ) {
            t = new ListNode();
            if(p != null) {
                t.val += p.val;
                p = p.next;
            }
            if(q != null) {
                t.val += q.val;
                q = q.next;
            }
            t.val += over;
            if(t.val >= 10) {
                t.val %= 10;
                over = 1;
            } else {
                over = 0;
            }

            k.next = t;
            k = t;
        }
        return h.next;
    }
}