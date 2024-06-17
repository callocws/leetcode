package leetcode._208;

import java.util.HashMap;

class Trie {

    class Node {
        HashMap<Character, Node> m = new HashMap();
        boolean isComplete;
    }
    Node head = new Node();

    public Trie() {
        
    }
    
    public void insert(String word) {
        Node p = head;
        for(char c : word.toCharArray()) {
            Node t = p.m.get(c);
            if(t == null) {
                t = new Node();
            }
            p.m.put(c, t);
            p = t;
        }
        p.isComplete = true;
    }
    
    public boolean search(String word) {
        Node p = head;
        for(char c : word.toCharArray()) {
            Node t = p.m.get(c);
            if(t == null) {
                return false;
            }
            p = t;
        }
        return p.isComplete;
    }
    
    public boolean startsWith(String prefix) {
        Node p = head;
        for(char c : prefix.toCharArray()) {
            Node t = p.m.get(c);
            if(t == null) {
                return false;
            }
            p = t;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */