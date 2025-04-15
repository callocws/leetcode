package leetcode._63;

class Solution {
    Integer dp[][];

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        dp = new Integer[m][n];
        return uniquePaths(obstacleGrid, 0, 0, m, n);
    }

    public int uniquePaths(int[][] obstacleGrid, int i, int j, int m, int n) {
        if (i == m || j == n || obstacleGrid[i][j] == 1) {
            return 0;
        }
        if (i == m - 1 && j == n - 1) {
            return 1;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        return dp[i][j] =
                uniquePaths(obstacleGrid, i + 1, j, m, n)
                        + uniquePaths(obstacleGrid, i, j + 1, m, n);
    }

    void printUniquePaths(int[][] obstacleGrid, int i, int j, int m, int n) {
        if (i == m || j == n || obstacleGrid[i][j] == 1) {
            return;
        }
        System.out.print(String.format("(%d,%d) -> ", i, j));
        if (uniquePaths(obstacleGrid, i, j, m, n) == uniquePaths(obstacleGrid, i + 1, j, m, n)) {
            printUniquePaths(obstacleGrid, i + 1, j, m, n);
        } else {
            printUniquePaths(obstacleGrid, i, j + 1, m, n);
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[][] obstacleGrid = {
            {0, 0, 1},
            {0, 1, 0},
            {0, 0, 0}
        };
        System.out.println(solution.uniquePathsWithObstacles(obstacleGrid));
        solution.printUniquePaths(obstacleGrid, 0, 0, obstacleGrid.length, obstacleGrid[0].length);
    }
}
