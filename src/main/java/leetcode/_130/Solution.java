package leetcode._130;

class Solution {
    public void solve(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1) {
                    traverse(board, i, j);
                }
            }
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'M') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    void traverse(char[][] A, int i, int j) {
        if(i < 0 || i >= A.length || j < 0 || j >= A[0].length || A[i][j] == 'X' || A[i][j] == 'M') {
            return;
        }
        A[i][j] = 'M';
        traverse(A, i + 1, j);
        traverse(A, i - 1, j);
        traverse(A, i, j + 1);
        traverse(A, i, j - 1);
    }
}