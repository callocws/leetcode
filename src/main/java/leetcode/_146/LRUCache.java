package leetcode._146;

import java.util.HashMap;

class LRUCache {
    
    class Node {
        int key;
        int val;
        Node pre;
        Node next;

        public Node(){}
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Node head = new Node();
    Node tail = new Node();
    int size = 0;
    int capacity = 0;
    HashMap<Integer, Node> h = new HashMap();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        Node t = h.get(key);
        if(t != null) {
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
        Node t = h.get(key);
        if(t != null) {
            t.pre.next = t.next;
            t.next.pre = t.pre;
            t.val = value;
        } else {
            t = new Node(key, value);
            size++;
            h.put(key, t);
        }
        t.pre = tail.pre;
        t.next = tail;
        tail.pre.next = t;
        tail.pre = t;
        if(size > capacity) {
            h.remove(head.next.key);
            head.next = head.next.next;
            head.next.pre = head;
            size--;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */