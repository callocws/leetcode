package leetcode._994;

import java.util.LinkedList;

class Solution {
    public int orangesRotting(int[][] grid) {
        LinkedList<int[]> q = new LinkedList();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 2) {
                    q.add(new int[]{i + 1, j});
                    q.add(new int[]{i, j + 1});
                    q.add(new int[]{i - 1, j});
                    q.add(new int[]{i, j - 1});
                }
            }
        }
        int d = 0;
        for(;!q.isEmpty(); d++) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int p[] = q.pop(), x = p[0], y = p[1];
                if(x < 0 || x >= grid.length || y < 0 || y >= grid[x].length || grid[x][y] == 2 || grid[x][y] == 0) {
                    continue;
                }
                grid[x][y] = 2;
                q.add(new int[]{x + 1, y});
                q.add(new int[]{x, y + 1});
                q.add(new int[]{x - 1, y});
                q.add(new int[]{x, y - 1});
            }
        }
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return d == 0 ? 0 : d - 1;
    }
}