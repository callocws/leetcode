package leetcode._64;

class Solution {
    Integer dp[][];

    public int minPathSum(int[][] grid) {
        dp = new Integer[grid.length][grid[0].length];
        return minPathSum(grid, 0, 0);
    }

    int minPathSum(int[][] grid, int i, int j) {
        if (i >= grid.length || j >= grid[0].length) {
            return Integer.MAX_VALUE;
        }
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        return dp[i][j] =
                grid[i][j] + Math.min(minPathSum(grid, i + 1, j), minPathSum(grid, i, j + 1));
    }
}
