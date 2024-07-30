package leetcode._1091;

import java.util.ArrayList;

class Solution {
    int dirs[][] = new int[][]{{-1, -1}, {0, -1}, {1, -1}, {-1, 0}, {1, 0}, {-1, 1}, {0, 1}, {1, 1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int cnt = 0;
        ArrayList<int[]> q = new ArrayList();
        q.add(new int[]{0, 0});
        for(int i = 0; i < q.size();) {
            cnt++;
            int size = q.size();
            for(;i < size; i++) {
                int indexes[] = q.get(i), x = indexes[0], y = indexes[1];
                if(x < 0 || x >= grid.length || y < 0 || y >= grid.length || grid[x][y] == 1) {
                    continue;
                }
                if(x == grid.length - 1 && y == grid.length - 1) {
                    return cnt;
                }
                grid[x][y] = 1;
                for(int[] dir : dirs) {
                    q.add(new int[]{x + dir[0], y + dir[1]});
                }
            }
        }
        return -1;
    }
}