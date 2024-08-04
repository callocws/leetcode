package leetcode._48;

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n / 2; i++) {
            for(int j = i; j < n - i - 1; j++) {
                rotate(matrix, i, j, 0, n);
            }
        }
    }

    void rotate(int[][] matrix, int i, int j, int depth, int n) {
        if(depth == 4) {
            return;
        }
        int v = matrix[i][j];
        rotate(matrix, j, n - i - 1, depth + 1, n);
        matrix[j][n - i - 1] = v;
    }
}