package leetcode._79;

class Solution {
    public boolean exist(char[][] board, String word) {
        char[] cs = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(traverse(board, cs, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    boolean traverse(char[][] A, char[] word, int i, int j, int t) {
        if(t == word.length) {
            return true;
        }
        
        if(i < 0 || i >= A.length || j < 0 || j >= A[0].length || A[i][j] == '#') {
            return false;
        }
        char c = A[i][j];
        if(c != word[t]) {
            return false;
        }

        A[i][j] = '#';

        if(traverse(A, word, i + 1, j, t + 1) || traverse(A, word, i, j + 1, t + 1) || traverse(A, word, i - 1, j, t + 1) || traverse(A, word, i, j - 1, t + 1)) {
            return true;
        }
        A[i][j] = c;
        return false;
    }
}