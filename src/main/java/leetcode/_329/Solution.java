package leetcode._329;

class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        dp = new Integer[matrix.length][matrix[0].length][matrix.length][matrix[0].length];
        int s = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                s = Math.max(s, longestIncreasingPath(matrix, i, j, -1, i, j));
            }
        }
        return s;
    }
    Integer dp[][][][];
    int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    int longestIncreasingPath(int[][] matrix, int i, int j, int last, int li, int lj) {
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] <= last) {
            return 0;
        }
        if(dp[i][j][li][lj] != null) {
            return dp[i][j][li][lj];
        }
        int s = 0;
        for(int[] d : dir) {
            s = Math.max(s, longestIncreasingPath(matrix, i + d[0], j + d[1], matrix[i][j], i, j));
        }
        return dp[i][j][li][lj] = 1 + s;
    }
}