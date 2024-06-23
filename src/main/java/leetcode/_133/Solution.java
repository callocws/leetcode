package leetcode._133;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class Solution {
    HashMap<Integer, Node> m = new HashMap();
    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }
        Node t = m.get(node.val);
        if(t != null) {
            return t;
        }
        t = new Node(node.val);
        m.put(node.val, t);
        
        for(Node p : node.neighbors) {
            t.neighbors.add(cloneGraph(p));
        }
        return t;
    }
}