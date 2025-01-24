package leetcode._208;

import java.util.HashMap;

class Trie {

    class Node {
        HashMap<Character, Node> map = new HashMap();
        boolean isComplete;
    }

    Node head = new Node();

    public Trie() {}

    public void insert(String word) {
        Node p = head;
        for (char c : word.toCharArray()) {
            p = p.map.computeIfAbsent(c, k -> new Node());
        }
        p.isComplete = true;
    }

    public boolean search(String word) {
        Node p = head;
        for (char c : word.toCharArray()) {
            p = p.map.get(c);
            if (p == null) {
                return false;
            }
        }
        return p.isComplete;
    }

    public boolean startsWith(String prefix) {
        Node p = head;
        for (char c : prefix.toCharArray()) {
            p = p.map.get(c);
            if (p == null) {
                return false;
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new Trie();
 * obj.insert(word); boolean param_2 = obj.search(word); boolean param_3 = obj.startsWith(prefix);
 */
class Trie1 {

    class Node {
        HashMap<Character, Node> map = new HashMap();
        boolean isComplete;

        void insert(String word) {
            if (word.length() == 0) {
                isComplete = true;
                return;
            }
            map.computeIfAbsent(word.charAt(0), k -> new Node()).insert(word.substring(1));
        }

        public boolean search(String word) {
            if (word.length() == 0) {
                return isComplete;
            }
            Node t = map.get(word.charAt(0));
            if (t == null) {
                return false;
            }
            return t.search(word.substring(1));
        }

        public boolean startsWith(String prefix) {
            if (prefix.length() == 0) {
                return true;
            }
            Node t = map.get(prefix.charAt(0));
            if (t == null) {
                return false;
            }
            return t.startsWith(prefix.substring(1));
        }
    }

    Node head = new Node();

    public Trie1() {}

    public void insert(String word) {
        head.insert(word);
    }

    public boolean search(String word) {
        return head.search(word);
    }

    public boolean startsWith(String prefix) {
        return head.startsWith(prefix);
    }
}
