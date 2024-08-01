package leetcode._1047;

class Solution {
    class Node {
        char value;
        Node previous;
        Node next;
        public Node() {}
        public Node(char value) {
            this.value = value;
        }
    }
    Node head = new Node(), tail = new Node();
    public String removeDuplicates(String s) {
        head.next = tail;
        tail.previous = head;
        Node p = head, q;
        for(char c : s.toCharArray()) {
            Node t = new Node(c);
            p.next = t;
            t.previous = p;
            t.next = tail;
            tail.previous = t;
            p = t;
        }
        for(p = head.next, q = head; p != tail;) {
            if(p.value == q.value) {
                p = p.next;
                q = q.previous;
                q.next = p;
                p.previous = q;
            } else {
                p = p.next;
                q = q.next;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(p = head.next; p != tail; p = p.next) {
            sb.append(p.value);
        }
        return sb.toString();
    }
}


class Solution1 {
    public String removeDuplicates(String s) {
        int left, right;
        char cs[] = s.toCharArray();
        for(left = right = 0; right < cs.length; right++) {
            if(left > 0 && cs[left - 1] == cs[right]) {
                left--;
            } else {
                cs[left++] = cs[right];
            }
        }
        return new String(cs, 0, left);
    }
}

