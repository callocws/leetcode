package leetcode._115;

class Solution {
    Integer dp[][];
    public int numDistinct(String s, String t) {
        dp = new Integer[t.length()][s.length()];
        return numDistinct(t, s, 0, 0);
    }

    int numDistinct(String t, String s, int i, int j) {
        if(i == t.length()) {
            return 1;
        }
        if(j == s.length()) {
            return 0;
        }
        if(dp[i][j] != null) {
            return dp[i][j];
        }
        int cnt = 0;
        if(t.charAt(i) == s.charAt(j)) {
            cnt += numDistinct(t, s, i + 1, j + 1);
        }
        cnt += numDistinct(t, s, i, j + 1);
        return dp[i][j] = cnt;
    }
}