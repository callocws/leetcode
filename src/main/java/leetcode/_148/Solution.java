package leetcode._148;

import leetcode.ListNode;

class Solution {
    ListNode dummy = new ListNode();

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p, q, pre;
        for (p = q = pre = head; q != null && q.next != null; ) {
            pre = p;
            p = p.next;
            q = q.next.next;
        }
        pre.next = null;
        return merge(sortList(head), sortList(p));
    }

    ListNode merge(ListNode p, ListNode q) {
        ListNode head, t;
        head = t = dummy;
        head.next = null;

        for (; p != null && q != null; ) {
            if (p.val <= q.val) {
                t = t.next = p;
                p = p.next;
            } else {
                t = t.next = q;
                q = q.next;
            }
        }
        t.next = p == null ? q : p;
        return head.next;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        Solution solution = new Solution();
        ListNode listNode = solution.sortList(head);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
