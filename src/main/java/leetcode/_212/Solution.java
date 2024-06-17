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
            if(search(board, clone1(B), word, calc(word))) {
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

    HashMap<Character, Integer> calc(String s) {
        HashMap<Character, Integer> m = new HashMap();
        for(char c : s.toCharArray()) {
            m.put(c, m.getOrDefault(c, 0) + 1);
        }
        return m;
    }

    boolean search(char[][] A, boolean[][] B, String word, HashMap<Character, Integer> m) {
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < A[i].length; j++) {
                if(f(A, clone1(B), i, j, m.clone())) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean f(char[][] A, boolean[][] B, int i, int j, Object h) {
        if(i < 0 || i >= A.length || j < 0 || j >= A[0].length) {
            return false;
        }

        HashMap<Character, Integer> m = (HashMap<Character, Integer>) h;

        Integer t = m.get(A[i][j]);
        if(B[i][j] || t == null || t <= 0) {
            return false;
        }
        B[i][j] = true;
        m.put(A[i][j], t - 1);

        int sum = 0;
        for (Integer value : m.values()) {
            sum += value;
        }

        return sum == 0 || f(A, clone1(B), i + 1, j, m.clone()) || f(A, clone1(B), i, j + 1, m.clone()) || f(A, clone1(B), i - 1, j, m.clone()) || f(A, clone1(B), i, j - 1, m.clone());
    }

    public static void main(String[] args) {
        // board =
        //[["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]]
        //words =
        //["oath","pea","eat","rain"]
        char[][] A = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};
        System.out.println(new Solution().findWords(A, words));

    }
}