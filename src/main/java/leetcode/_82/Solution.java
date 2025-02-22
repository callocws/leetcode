package leetcode._82;

import java.util.ArrayList;
import leetcode.ListNode;

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ArrayList<ListNode> list = new ArrayList();
        boolean delete = false;
        for (ListNode p = head; p != null; p = p.next) {
            if (!list.isEmpty() && list.getLast().val == p.val) {
                delete = true;
            } else {
                if (delete) {
                    list.removeLast();
                    delete = false;
                }
                list.add(p);
            }
        }
        if (delete) {
            list.removeLast();
        }
        if (list.isEmpty()) {
            return null;
        }
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).next = list.get(i + 1);
        }
        list.getLast().next = null;
        return list.get(0);
    }
}
