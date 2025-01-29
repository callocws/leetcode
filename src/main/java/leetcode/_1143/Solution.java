package leetcode._1143;

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length(), dp[][] = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i] = new int[m + 1];
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = Math.max(1 + dp[i - 1][j - 1], dp[i][j]);
                }
            }
        }
        return dp[n][m];
    }
}

class Solution1 {
    Integer dp[][];

    public int longestCommonSubsequence(String text1, String text2) {
        dp = new Integer[text1.length() + 1][text2.length() + 1];
        return longestCommonSubsequence(text1, text2, 0, 0);
    }

    public int longestCommonSubsequence(String text1, String text2, int i, int j) {
        if (i >= text1.length() || j >= text2.length()) {
            return 0;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        int ans =
                (text1.charAt(i) == text2.charAt(j))
                        ? 1 + longestCommonSubsequence(text1, text2, i + 1, j + 1)
                        : 0;
        return dp[i][j] =
                Math.max(
                        ans,
                        Math.max(
                                longestCommonSubsequence(text1, text2, i + 1, j),
                                longestCommonSubsequence(text1, text2, i, j + 1)));
    }
}
