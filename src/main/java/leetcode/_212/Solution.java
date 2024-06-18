package leetcode._212;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        boolean B[][] = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
            B[i] = new boolean[board[i].length];
        }

        LinkedList<String> l = new LinkedList();
        for(String word : words) {
            if(search(board, clone1(B), word)) {
                l.add(word);
            }
        }
        return l;
    }

     public static boolean[][] clone1(boolean[][] original) {
        boolean[][] clone = new boolean[original.length][];
        for (int i = 0; i < original.length; i++) {
            clone[i] = original[i].clone();
        }
         return clone;
     }

    boolean search(char[][] A, boolean[][] B, String word) {
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < A[i].length; j++) {
                if(f(A, clone1(B), i, j, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean f(char[][] A, boolean[][] B, int i, int j, String word) {
        if (word.equals("")) {
            return true;
        }

        if(i < 0 || i >= A.length || j < 0 || j >= A[0].length) {
            return false;
        }

        if(B[i][j] || A[i][j] != word.charAt(0)) {
            return false;
        }
        B[i][j] = true;

        String s = word.substring(1);

        return f(A, clone1(B), i + 1, j, s) || f(A, clone1(B), i, j + 1, s) || f(A, clone1(B), i - 1, j, s) || f(A, clone1(B), i, j - 1, s);
    }

    public static void main(String[] args) {
        // board =
        //[["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]]
        //words =
        //["oath","pea","eat","rain"]
        char[][] A = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};
        System.out.println(new Solution().findWords(A, words));

        // board =
        //[["a"]]
        //words =
        //["a"]
        //
        //Use Testcase
        //Output
        //[]
        char[][] B = {{'a'}};
        String[] words1 = {"a"};
        System.out.println(new Solution().findWords(B, words1));

    }
}


class Solution1 {

    class Node {
        HashMap<Character, Node> m = new HashMap();

        Node add(char c) {
            Node t = m.get(c);
            if(t == null) {
                t = new Node();
            }
            m.put(c, t);
            return t;
        }
    }
    Node head = new Node();

    public List<String> findWords(char[][] board, String[] words) {
        boolean B[][] = new boolean[board.length][];
        for(int i = 0; i < board.length; i++) {
            B[i] = new boolean[board[i].length];
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                f(head, board, clone1(B), i, j);
            }
        }

        LinkedList<String> l = new LinkedList();
        for(String word : words) {
            if(f(head, word)) {
                l.add(word);
            }
        }
        return l;
    }

    boolean f(Node p, String word) {
        if (word.equals("")) {
            return true;
        }

        Node t = p.m.get(word.charAt(0));
        if(t == null) {
            return false;
        }
        return f(t, word.substring(1));
    }

    void f(Node p, char[][] A, boolean[][] B, int i, int j) {
        if(i < 0 || i >= A.length || j < 0 || j >= A[0].length || B[i][j]) {
            return;
        }
        p = p.add(A[i][j]);
        B[i][j] = true;

        f(p, A, clone1(B), i + 1, j);
        f(p, A, clone1(B), i, j + 1);
        f(p, A, clone1(B), i - 1, j);
        f(p, A, clone1(B), i, j - 1);
    }

    public static boolean[][] clone1(boolean[][] original) {
        boolean[][] clone = new boolean[original.length][];
        for (int i = 0; i < original.length; i++) {
            clone[i] = original[i].clone();
        }
        return clone;
    }
}

class Solution2 {

    class Node {
        HashMap<Character, Node> m = new HashMap();

        Node add(char c) {
            Node t = m.get(c);
            if(t == null) {
                t = new Node();
            }
            m.put(c, t);
            return t;
        }
    }
    Node head = new Node();

    public List<String> findWords(char[][] board, String[] words) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                f(head, board, i, j);
            }
        }

        LinkedList<String> l = new LinkedList();
        for(String word : words) {
            if(f(head, word)) {
                l.add(word);
            }
        }
        return l;
    }

    boolean f(Node p, String word) {
        if (word.equals("")) {
            return true;
        }

        Node t = p.m.get(word.charAt(0));
        if(t == null) {
            return false;
        }
        return f(t, word.substring(1));
    }

    void f(Node p, char[][] A, int i, int j) {
        if(i < 0 || i >= A.length || j < 0 || j >= A[0].length || A[i][j] == '#') {
            return;
        }
        char c = A[i][j];
        p = p.add(c);
        A[i][j] = '#';

        f(p, A, i + 1, j);
        f(p, A, i, j + 1);
        f(p, A, i - 1, j);
        f(p, A, i, j - 1);
        A[i][j] = c;
    }

    public static void main(String[] args) {
        char[][] board = {
            {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
            {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
            {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
            {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
//            {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
//            {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
//            {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
//            {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
//            {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
//            {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
//            {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
//            {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'}
        };

        String[] words = {
            "a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"
        };

        Solution2 solution = new Solution2();
        List<String> result = solution.findWords(board, words);
        System.out.println(result);
    }
}

class Solution3 {

    class Node {
        HashMap<Character, Node> m = new HashMap();
        String word;

        Node add(char c) {
            Node t = m.get(c);
            if(t == null) {
                t = new Node();
            }
            m.put(c, t);
            return t;
        }

        Node add(String s) {
            Node t = this;
            for(char c: s.toCharArray()) {
                t = t.add(c);
            }
            t.word = s;
            return t;
        }
    }
    Node head = new Node();
    LinkedList<String> l = new LinkedList();

    public List<String> findWords(char[][] board, String[] words) {
        for(String word : words) {
            head.add(word);
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                f(head, board, i, j);
            }
        }

        return l;
    }

    void f(Node p, char[][] A, int i, int j) {
        if(i < 0 || i >= A.length || j < 0 || j >= A[0].length || A[i][j] == '#') {
            return;
        }
        char c = A[i][j];
        p = p.m.get(c);
        if(p == null) {
            return;
        }
        if(p.word != null) {
            l.add(p.word);
            p.word = null;
        }

        A[i][j] = '#';
        f(p, A, i + 1, j);
        f(p, A, i, j + 1);
        f(p, A, i - 1, j);
        f(p, A, i, j - 1);
        A[i][j] = c;
    }
}