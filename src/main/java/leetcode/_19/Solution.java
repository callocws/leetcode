package leetcode._19;

import leetcode.ListNode;

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p, q, k = new ListNode();
        int i = 0;
        for (p = q = k, k.next = head; p != null; ) {
            if (i++ > n) {
                q = q.next;
            }
            p = p.next;
        }
        q.next = q.next.next;
        return k.next;
    }
}

class Solution1 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode h = new ListNode();
        h.next = head;
        dfs(h, n);
        return h.next;
    }

    int dfs(ListNode head, int n) {
        if (head == null) {
            return 0;
        }
        int t = dfs(head.next, n) + 1;
        if (t == n + 1) {
            head.next = head.next.next;
        }
        return t;
    }
}
