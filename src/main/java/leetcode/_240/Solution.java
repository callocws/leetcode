package leetcode._240;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0, j = matrix[0].length - 1;
        for (; i < matrix.length && j >= 0; ) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}

class Solution1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        return searchMatrix(matrix, target, 0, matrix[0].length - 1);
    }

    boolean searchMatrix(int[][] matrix, int target, int i, int j) {
        if (i >= matrix.length || j < 0) {
            return false;
        }
        if (target == matrix[i][j]) {
            return true;
        }
        if (target < matrix[i][j]) {
            return searchMatrix(matrix, target, i, j - 1);
        }
        return searchMatrix(matrix, target, i + 1, j);
    }
}
