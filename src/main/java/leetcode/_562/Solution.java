package leetcode._562;

class Solution {
    public int longestLine(int[][] mat) {
        int cnt = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        cnt =
                                Math.max(
                                        longestLine(mat, i, j, k * 2)
                                                + longestLine(mat, i, j, k * 2 + 1)
                                                - 1,
                                        cnt);
                    }
                }
            }
        }
        return cnt;
    }

    int dirs[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {-1, -1}, {1, 1}, {1, -1}, {-1, 1}};

    int longestLine(int[][] mat, int i, int j, int d) {
        if (i >= 0 && j >= 0 && i < mat.length && j < mat[i].length && mat[i][j] != 0) {
            return 1 + longestLine(mat, i + dirs[d][0], j + dirs[d][1], d);
        }
        return 0;
    }
}
