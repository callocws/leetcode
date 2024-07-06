package leetcode._778;

import java.util.PriorityQueue;

class Solution {
    public int swimInWater(int[][] grid) {
        int max = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                max = Math.max(max, grid[i][j]);
            }
        }
        int l = grid[grid.length - 1][grid[0].length - 1], r = max, m = (l + r) >> 1;
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

class Solution1 {
    public int swimInWater(int[][] grid) {
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        pq.add(new int[]{grid[0][0], 0, 0});
        int direc[][] = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for(;!pq.isEmpty();) {
            int p[] = pq.poll(), x = p[1], y = p[2];
            if(grid[x][y] == grid[grid.length - 1][grid[0].length - 1]) {
                return p[0];
            }
            visited[x][y] = true;
            for(int[] d : direc) {
                int x1 = x + d[0], y1 = y + d[1];
                if(!notValid(grid, visited, x1, y1)) {
                    pq.add(new int[]{Math.max(p[0], grid[x1][y1]), x1, y1});
                }
            }
        }
        return -1;
    }

    boolean notValid(int[][] grid, boolean visited[][], int x, int y) {
        return x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || visited[x][y];
    }
}