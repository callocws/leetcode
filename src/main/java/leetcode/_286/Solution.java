package leetcode._286;

class Solution {
    public void islandsAndTreasure(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    traverse(grid, i, j, 0);
                }
            }
        }
    }

    void traverse(int[][] A, int i, int j, int n) {
        if (i < 0 || j < 0 || i >= A.length || j >= A[0].length || A[i][j] == -1) {
            return;
        }
        if (A[i][j] < n) {
            return;
        }

        int t = Math.min(A[i][j], n);
        A[i][j] = -1;
        n++;
        traverse(A, i - 1, j, n);
        traverse(A, i, j - 1, n);
        traverse(A, i + 1, j, n);
        traverse(A, i, j + 1, n);
        A[i][j] = t;
    }
}

class Solution1 {
    public void wallsAndGates(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    traverse(grid, i, j, 0);
                }
            }
        }
    }

    void traverse(int[][] A, int i, int j, int distance) {
        if (i < 0
                || j < 0
                || i >= A.length
                || j >= A[0].length
                || A[i][j] == -1
                || distance > 0 && A[i][j] <= distance) {
            return;
        }
        A[i][j] = distance++;
        traverse(A, i - 1, j, distance);
        traverse(A, i, j - 1, distance);
        traverse(A, i + 1, j, distance);
        traverse(A, i, j + 1, distance);
    }
}
