package leetcode._120;

import java.util.List;

class Solution {
    Integer dp[][];
    int n;

    public int minimumTotal(List<List<Integer>> triangle) {
        n = triangle.size();
        dp = new Integer[n][n];
        return minimumTotal(triangle, 0, 0);
    }

    int minimumTotal(List<List<Integer>> triangle, int i, int j) {
        if (i >= n || j >= n) {
            return 0;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        return dp[i][j] =
                triangle.get(i).get(j)
                        + Math.min(
                                minimumTotal(triangle, i + 1, j),
                                minimumTotal(triangle, i + 1, j + 1));
    }
}
