package leetcode._200;

class Solution {
    public int numIslands(char[][] grid) {
        int cnt = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    cnt++;
                    traverse(grid, i, j);
                }
            }
        }
        return cnt;
    }

    void traverse(char[][] A, int i, int j) {
        if(i < 0 || j < 0 || i >= A.length || j >= A[0].length || A[i][j] != '1') {
            return;
        }
        A[i][j] = '#';
        traverse(A, i - 1, j);
        traverse(A, i, j - 1);
        traverse(A, i + 1, j);
        traverse(A, i, j + 1);
    }
}