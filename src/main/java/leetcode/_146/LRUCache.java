package leetcode._146;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    class Node {
        int key;
        int val;
        Node pre;
        Node next;

        public Node() {}

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Node head = new Node();
    Node tail = new Node();
    int size = 0;
    int capacity = 0;
    Map<Integer, Node> map = new HashMap();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        Node t = map.get(key);
        if (t != null) {
            t.pre.next = t.next;
            t.next.pre = t.pre;
        } else {
            return -1;
        }

        t.pre = tail.pre;
        t.next = tail;
        tail.pre.next = t;
        tail.pre = t;

        return t.val;
    }

    public void put(int key, int value) {
        if (get(key) != -1) {
            map.get(key).val = value;
            return;
        }
        if (size == capacity) {
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.pre = head;
            size--;
        }
        Node t = new Node(key, value);
        t.next = tail;
        t.pre = tail.pre;
        tail.pre.next = t;
        tail.pre = t;
        size++;
        map.put(key, t);
    }
}
