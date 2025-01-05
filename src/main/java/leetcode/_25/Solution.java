package leetcode._25;

import java.util.LinkedList;
import leetcode.ListNode;

class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        LinkedList<ListNode> list = new LinkedList();
        ListNode p = head, q, newHead = new ListNode(), t = newHead, next;
        for (int i = 1; p != null; p = next, i++) {
            next = p.next;
            list.add(p);
            if (i == k) {
                while (!list.isEmpty()) {
                    t = t.next = list.removeLast();
                    t.next = null;
                }
                i = 0;
            }
        }
        if (!list.isEmpty()) {
            t.next = list.pop();
        }
        return newHead.next;
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

class Solution1_1 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode p = head, nextHead, newHead;
        for (int i = 1; p != null && i < k; i++) {
            p = p.next;
        }
        if (p == null) {
            return head;
        }

        nextHead = reverseKGroup(p.next, k);
        newHead = reverse(head, k);
        head.next = nextHead;
        return newHead;
    }

    ListNode reverse(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        ListNode p = reverse(head.next, k - 1);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
