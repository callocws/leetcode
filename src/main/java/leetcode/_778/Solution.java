package leetcode._778;

class Solution {
    public int swimInWater(int[][] grid) {
        int max = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                max = Math.max(max, grid[i][j]);
            }
        }
        int l = 0, r = max, m = (l + r) >> 1;
        for(;l < r; m = (l + r) >> 1) {
            if(dfs(grid, m, 0, 0)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return m;
    }

    boolean dfs(int[][] grid, int t, int x, int y) {
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 5000 || grid[x][y] > t) {
            return false;
        }
        if(x == grid.length - 1 && y == grid[0].length - 1) {
            return true;
        }
        int k = grid[x][y];
        grid[x][y] = 5000;
        if(dfs(grid, t, x + 1, y) || dfs(grid, t, x - 1, y) || dfs(grid, t, x, y + 1) || dfs(grid, t, x, y - 1)) {
            grid[x][y] = k;
            return true;
        }
        grid[x][y] = k;
        return false;
    }
}