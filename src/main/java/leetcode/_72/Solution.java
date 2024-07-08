package leetcode._72;

class Solution {
    Integer dp[][];
    public int minDistance(String word1, String word2) {
        dp = new Integer[word1.length()][word2.length()];
        return minDistance(word1, word2, 0, 0);
    }

    int minDistance(String A, String B, int i, int j) {
        if(i >= A.length()) {
            return B.length() - j;
        }
        if(j >= B.length()) {
            return A.length() - i;
        }
        if(dp[i][j] != null) {
            return dp[i][j];
        }

        int s = Integer.MAX_VALUE;
        if(A.charAt(i) == B.charAt(j)) {
            s = minDistance(A, B, i + 1, j + 1);
        } else {
            s = Math.min(s, minDistance(A, B, i, j + 1) + 1);
            s = Math.min(s, minDistance(A, B, i + 1, j + 1) + 1);
            s = Math.min(s, minDistance(A, B, i + 1, j) + 1);
        }        
        return dp[i][j] = s;
    }
}