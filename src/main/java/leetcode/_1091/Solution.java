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

class Solution1 {
    int dirs[][] = new int[][]{{-1, -1}, {0, -1}, {1, -1}, {-1, 0}, {1, 0}, {-1, 1}, {0, 1}, {1, 1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int cnt = 0, parent[][] = new int[grid.length][grid.length];
        ArrayList<int[]> q = new ArrayList();
        q.add(new int[]{0, 0, 0});
        for(int i = 0; i < q.size();) {
            cnt++;
            int size = q.size();
            for(;i < size; i++) {
                int indexes[] = q.get(i), x = indexes[0], y = indexes[1];
                if(x < 0 || x >= grid.length || y < 0 || y >= grid.length || grid[x][y] == 1) {
                    continue;
                }
                grid[x][y] = 1;
                parent[x][y] = indexes[2];
                if(x == grid.length - 1 && y == grid.length - 1) {
                    build(parent, x, y);
                    return cnt;
                }
                for(int[] dir : dirs) {
                    q.add(new int[]{x + dir[0], y + dir[1],  x * grid.length + y});
                }
            }
        }
        return -1;
    }
    void build(int parent[][], int x, int y) {
        if(x == 0 && y == 0) {
            System.out.println(0 + "," + 0);
            return ;
        }
        build(parent, parent[x][y] / parent.length, parent[x][y] % parent.length);
        System.out.println(x + "," + y);
    }

    public static void main(String[] args) {
        int grid[][] = new int[][]{{0, 1}, {1, 0}};
        System.out.println(new Solution1().shortestPathBinaryMatrix(grid));

        grid = new int[][]{{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        System.out.println(new Solution1().shortestPathBinaryMatrix(grid));

        // [[0,0,0],[0,1,0],[0,0,0]]
        grid = new int[][]{{0,0,0}, {0,1,0}, {0,0,0}};
        System.out.println(new Solution1().shortestPathBinaryMatrix(grid));

        grid = new int[][]{{1,0,0}, {1,1,0}, {1,1,0}};
        System.out.println(new Solution1().shortestPathBinaryMatrix(grid));
    }
}
