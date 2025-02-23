package leetcode._86;

import leetcode.ListNode;

class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode list1 = new ListNode(), list2 = new ListNode(), p = list1, q = list2, cur = head;
        for (; cur != null; cur = cur.next) {
            if (cur.val < x) {
                p = p.next = cur;
            } else {
                q = q.next = cur;
            }
        }
        p.next = list2.next;
        q.next = null;
        return list1.next;
    }
}
