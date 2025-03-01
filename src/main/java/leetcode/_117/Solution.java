package leetcode._117;

import java.util.ArrayList;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

class Solution {
    public Node connect(Node root) {
        ArrayList<Node> list = new ArrayList();
        list.add(root);
        for (int i = 0; i < list.size(); ) {
            int size = list.size();
            Node previous = null;
            for (; i < size; i++) {
                Node node = list.get(i);
                if (node != null) {
                    list.add(node.left);
                    list.add(node.right);
                    if (previous != null) {
                        previous.next = node;
                    }
                    previous = node;
                }
            }
        }
        return root;
    }
}

class Solution1 {
    ArrayList<Node> list = new ArrayList();

    public Node connect(Node root) {
        connect(root, 0);
        return root;
    }

    void connect(Node root, int depth) {
        if (root == null) {
            return;
        }
        if (list.size() <= depth) {
            list.add(root);
        } else {
            list.get(depth).next = root;
            list.set(depth, root);
        }
        connect(root.left, depth + 1);
        connect(root.right, depth + 1);
    }
}
