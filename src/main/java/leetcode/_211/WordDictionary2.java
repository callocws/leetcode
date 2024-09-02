package leetcode._211;

import java.util.HashMap;

class WordDictionary {

    class Node {
        Node[] ns = new Node[128];
        boolean isComplete;
    }

    Node head = new Node();

    public WordDictionary() {}

    public void addWord(String word) {
        Node p = head;
        for (char c : word.toCharArray()) {
            Node t = p.ns[c];
            if (t == null) {
                t = new Node();
            }
            p.ns[c] = t;
            p = t;
        }
        p.isComplete = true;
    }

    public boolean search(String word) {
        return search(head, word);
    }

    boolean search(Node p, String word) {
        char cs[] = word.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            if (c == '.') {
                for (int j = 0; j < 26; j++) {
                    if (search(p, (char) ('a' + j) + word.substring(i + 1))) {
                        return true;
                    }
                }
                return false;
            }
            Node t = p.ns[c];
            if (t == null) {
                return false;
            }
            p = t;
        }
        return p.isComplete;
    }
}

class WordDictionary1 {

    public class Node {
        Node[] ns = new Node[128];
        boolean isComplete;
    }

    Node head = new Node();

    public WordDictionary1() {}

    public void addWord(String word) {
        Node p = head;
        for (char c : word.toCharArray()) {
            Node t = p.ns[c];
            if (t == null) {
                t = new Node();
            }
            p.ns[c] = t;
            p = t;
        }
        p.isComplete = true;
    }

    public boolean search(String word) {
        return search(head, word);
    }

    boolean search(Node p, String word) {
        char cs[] = word.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            if (c == '.') {
                for (int j = 0; j < 128; j++) {
                    if (p.ns[j] != null && search(p.ns[j], word.substring(i + 1))) {
                        return true;
                    }
                }
                return false;
            }
            Node t = p.ns[c];
            if (t == null) {
                return false;
            }
            p = t;
        }
        return p.isComplete;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such: WordDictionary obj = new
 * WordDictionary(); obj.addWord(word); boolean param_2 = obj.search(word);
 */
class WordDictionary2 {

    public WordDictionary2() {}

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
            if (word.charAt(0) == '.') {
                for (Node t : map.values()) {
                    if (t.search(word.substring(1))) {
                        return true;
                    }
                }
                return false;
            }
            Node t = map.get(word.charAt(0));
            if (t == null) {
                return false;
            }
            return t.search(word.substring(1));
        }
    }

    Node head = new Node();

    public void addWord(String word) {
        head.insert(word);
    }

    public boolean search(String word) {
        return head.search(word);
    }
}
