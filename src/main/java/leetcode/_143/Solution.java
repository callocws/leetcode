package leetcode._143;

import java.util.ArrayList;
import java.util.LinkedList;
import leetcode.ListNode;

class Solution {
    public void reorderList(ListNode head) {
        ListNode p = head, q, t;
        LinkedList<ListNode> l = new LinkedList();
        for (; p != null; p = p.next) {
            l.add(p);
        }
        p = head;
        for (int i = 0, n = l.size(); i < n / 2; i++) {
            t = p.next;
            p.next = q = l.removeLast();
            q.next = t;
            p = t;
        }
        p.next = null;
    }
}

class Solution1 {
    public void reorderList(ListNode head) {
        ListNode p = head;
        ArrayList<ListNode> l = new ArrayList();
        for (; p != null; p = p.next) {
            l.add(p);
        }
        p = head;
        for (int i = 0, n = l.size() - 1; i <= n / 2; i++) {
            p = p.next = l.get(i);
            p = p.next = l.get(n - i);
        }
        p.next = null;
    }
}
