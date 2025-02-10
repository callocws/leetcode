package leetcode._289;

class Solution {
    public void gameOfLife(int[][] board) {
        int board1[][] = new int[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int live = 0;
                for (int x = -1; x < 2; x++) {
                    for (int y = -1; y < 2; y++) {
                        if (valid(board, i + x, j + y)) {
                            live++;
                        }
                    }
                }
                if (board[i][j] == 1) {
                    live--;
                    if (live == 2 || live == 3) {
                        board1[i][j]++;
                    }
                } else if (live == 3) {
                    board1[i][j]++;
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = board1[i][j];
            }
        }
    }

    boolean valid(int[][] board, int i, int j) {
        return i >= 0 && i < board.length && j >= 0 && j < board[i].length && board[i][j] == 1;
    }
}
