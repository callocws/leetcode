package leetcode._36;

import java.util.Arrays;


// 36. Valid Sudoku
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int A[] = new int[10];
        
        for(int i = 0; i < 9; i++) {
            Arrays.fill(A, 0);
            for(int j = 0; j < 9; j++) {
                if(!isValid(board[i][j], A)) {
                    return false;
                }
            }
        }
        
        for(int i = 0; i < 9; i++) {
            Arrays.fill(A, 0);
            for(int j = 0; j < 9; j++) {
                if(!isValid(board[j][i], A)) {
                    return false;
                }
            }
        }

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                Arrays.fill(A, 0);
                for(int k = 0; k < 3; k++) {
                    for(int t = 0; t < 3; t++) {
                        int x = i * 3 + k;
                        int y = j * 3 + t;
                        if(!isValid(board[x][y], A)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    boolean isValid(char c, int[] A) {
        if(c == '.') {
            return true;
        }
        int i = c - '0';
        return A[i]++ == 0;
    }
}