package leetcode._1143;

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length(), dp[][] = new int[n + 1][m + 1];
        for(int i = 0; i < n + 1; i++) {
            dp[i] = new int[m + 1];
        }
        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < m + 1; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if(text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = Math.max(1 + dp[i - 1][j - 1], dp[i][j]);
                }
            }
        }
        return dp[n][m];
    }
}