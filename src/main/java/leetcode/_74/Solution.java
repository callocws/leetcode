package leetcode._74;

// 74. Search a 2D Matrix
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0, j = matrix.length - 1, t;
        for(; i <= j;) {
            int m = (i + j) >> 1;
            if(matrix[m][0] == target) {
                return true;
            } else if(matrix[m][0] < target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        if(j < 0) {
            return false;
        }
        for(t = j, i = 0, j = matrix[t].length - 1; i <= j;) {
            int m = (i + j) >> 1;
            if(matrix[t][m] == target) {
                return true;
            } else if(matrix[t][m] < target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return false;
    }
}

class Solution1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int M = matrix.length, N = matrix[0].length;
        for(int i = 0, j = M * N - 1; i <= j;) {
            int m = (i + j) >> 1;
            if(matrix[m / N][m % N] == target) {
                return true;
            } else if(matrix[m / N][m % N] < target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return false;
    }
}


class Solution2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int M = matrix.length, N = matrix[0].length;
        for(int i = 0, j = M * N; i < j;) {
            int m = (i + j) >> 1;
            int r = m / N;
            int c = m % N;
            int v = matrix[r][c];
            if(v == target) {
                return true;
            } else if(v < target) {
                i = m + 1;
            } else {
                j = m;
            }
        }
        return false;
    }
    public static void main(String[] args){
        System.out.println(new Solution2().searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 3));
    }
}