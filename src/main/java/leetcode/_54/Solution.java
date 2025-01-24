package leetcode._54;

import java.util.ArrayList;
import java.util.List;

class Solution {
    int dirs[][] = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    ArrayList<Integer> result = new ArrayList();

    public List<Integer> spiralOrder(int[][] matrix) {
        dfs(matrix, 0, 0, 0);
        return result;
    }

    void dfs(int[][] matrix, int i, int j, int d) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] == 101) {
            return;
        }
        result.add(matrix[i][j]);
        matrix[i][j] = 101;
        for (int di = d; di != (d - 1 + 4) % 4; di = (di + 1) % 4) {
            dfs(matrix, i + dirs[di][0], j + dirs[di][1], di);
        }
    }
}

class Solution1 {
    int dirs[][] = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    ArrayList<Integer> result = new ArrayList();

    public List<Integer> spiralOrder(int[][] matrix) {
        dfs(matrix, 0, 0, 0);
        return result;
    }

    void dfs(int[][] matrix, int i, int j, int d) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] == 101) {
            return;
        }
        result.add(matrix[i][j]);
        matrix[i][j] = 101;
        dfs(matrix, i + dirs[d][0], j + dirs[d][1], d);
        d = (d + 1) % 4;
        dfs(matrix, i + dirs[d][0], j + dirs[d][1], d);
    }
}
