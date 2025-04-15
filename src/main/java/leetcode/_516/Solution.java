package leetcode._516;

class Solution {
    int max = 0;
    Integer dp[][];

    public int longestPalindromeSubseq(String s) {
        dp = new Integer[s.length()][s.length()];
        for (int i = 0, len1 = 0, len2 = 0; i < s.length(); i++) {
            len1 = longestPalindromeSubseq(s, i, i);
            if (i > 0) {
                len2 = longestPalindromeSubseq(s, i - 1, i);
            }
            max = Math.max(max, Math.max(len1, len2));
        }
        return max;
    }

    int longestPalindromeSubseq(String s, int i, int j) {
        if (i < 0 || j >= s.length()) {
            return 0;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        if (s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = (i == j ? 1 : 2) + longestPalindromeSubseq(s, i - 1, j + 1);
        }
        return dp[i][j] =
                Math.max(
                        longestPalindromeSubseq(s, i - 1, j), longestPalindromeSubseq(s, i, j + 1));
    }
}
