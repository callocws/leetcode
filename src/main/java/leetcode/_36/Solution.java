package leetcode._36;

import java.util.Arrays;
import java.util.HashSet;


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


class Solution1 {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> s = new HashSet();
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                char c = board[i][j];
                if(c != '.'
                    && (!s.add(String.format("i:%d:%s", i, c))
                    || !s.add(String.format("j:%d:%s", j, c))
                    || !s.add(String.format("%d,%d:%s", i/3, j/3, c)))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // [["8","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
        char[][] board = new char[][]{
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8','.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println(new Solution1().isValidSudoku(board));

    }
}