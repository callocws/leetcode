package leetcode._212;

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