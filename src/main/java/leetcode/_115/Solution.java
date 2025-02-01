package leetcode._115;

class Solution {
    Integer dp[][];

    public int numDistinct(String s, String t) {
        dp = new Integer[s.length()][t.length()];
        return numDistinct(s, t, 0, 0);
    }

    int numDistinct(String s, String t, int i, int j) {
        if (j == t.length()) {
            return 1;
        }
        if (i == s.length() || s.length() - i < t.length() - j) {
            return 0;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        return dp[i][j] =
                numDistinct(s, t, i + 1, j)
                        + (s.charAt(i) == t.charAt(j) ? numDistinct(s, t, i + 1, j + 1) : 0);
    }
}
