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

    void printPathSum(int[][] grid, int i, int j) {
        if (i >= grid.length || j >= grid[0].length) {
            return;
        }
        System.out.println(grid[i][j] + "->");

        if (minPathSum(grid, i + 1, j) < minPathSum(grid, i, j + 1)) {
            printPathSum(grid, i + 1, j);
        } else {
            printPathSum(grid, i, j + 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例输入
        int[][] grid = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        };

        // 计算最小路径和并初始化 dp 表
        int minSum = solution.minPathSum(grid);
        System.out.println("最小路径和: " + minSum);

        // 打印最小路径
        System.out.println("最小路径:");
        solution.printPathSum(grid, 0, 0);
    }
}
