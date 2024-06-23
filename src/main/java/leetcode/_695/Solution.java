package leetcode._695;

class Solution {
    int cnt = 0;
    int n = 0;
    public int maxAreaOfIsland(int[][] grid) {    
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    n = 0;
                    traverse(grid, i, j);
                }
            }
        }
        return cnt;
    }

    void traverse(int[][] A, int i, int j) {
        if(i < 0 || j < 0 || i >= A.length || j >= A[0].length || A[i][j] != 1) {
            return;
        }
        A[i][j] = 2;
        n++;
        cnt = Math.max(cnt, n);
        traverse(A, i - 1, j);
        traverse(A, i, j - 1);
        traverse(A, i + 1, j);
        traverse(A, i, j + 1);
    }
}