package leetcode._25;

import java.util.LinkedList;
import leetcode.ListNode;

class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        LinkedList<ListNode> l = new LinkedList();
        ListNode p = head, q, h = new ListNode(), t = h, e;
        for (int i = 0; p != null; p = e) {
            e = p.next;
            l.add(p);
            if (++i == k) {
                do {
                    q = l.removeLast();
                    t.next = q;
                    t = q;
                } while (!l.isEmpty());
                i = 0;
            }
        }
        t.next = null;
        for (; !l.isEmpty(); ) {
            q = l.pop();
            t.next = q;
            t = q;
        }
        return h.next;
    }
}

class Solution1 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode p = head, nextHead, newHead;
        for (int i = 1; p != null && i < k; i++) {
            p = p.next;
        }
        if (p == null) {
            return head;
        }
        nextHead = reverseKGroup(p.next, k);
        p.next = null;
        newHead = reverse(head);
        head.next = nextHead;
        return newHead;
    }

    ListNode reverse(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode p = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
