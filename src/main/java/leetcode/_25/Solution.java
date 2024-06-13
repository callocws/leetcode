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







