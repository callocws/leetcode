package leetcode._97;

class Solution {
    Boolean[][][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        dp = new Boolean[s1.length() + 1][s2.length() + 1][s3.length() + 1];
        return s1.length() + s2.length() == s3.length() && isInterleave(s1, s2, s3, 0, 0, 0);
    }

    boolean isInterleave(String s1, String s2, String s3, int i1, int i2, int i3) {
        if(i1 + i2 == s3.length()) {
            return true;
        }
        if(dp[i1][i2][i3] != null) {
            return dp[i1][i2][i3];
        }
        if(i1 < s1.length() && s3.charAt(i3) == s1.charAt(i1) && isInterleave(s1, s2, s3, i1 + 1, i2, i3 + 1)) {
            return true;
        } else if(i2 < s2.length() && s3.charAt(i3) == s2.charAt(i2) && isInterleave(s1, s2, s3, i1, i2 + 1, i3 + 1)) {
            return true;
        }
        dp[i1][i2][i3] = false;
        return false;
    }
}

class Solution1 {
    Boolean[][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        dp = new Boolean[s1.length() + 1][s2.length() + 1];
        return s1.length() + s2.length() == s3.length() && isInterleave(s1, s2, s3, 0, 0);
    }

    boolean isInterleave(String s1, String s2, String s3, int i1, int i2) {
        if(i1 + i2 == s3.length()) {
            return true;
        }
        if(dp[i1][i2] != null) {
            return dp[i1][i2];
        }
        if(i1 < s1.length() && s3.charAt(i1 + i2) == s1.charAt(i1) && isInterleave(s1, s2, s3, i1 + 1, i2)) {
            return true;
        } else if(i2 < s2.length() && s3.charAt(i1 + i2) == s2.charAt(i2) && isInterleave(s1, s2, s3, i1, i2 + 1)) {
            return true;
        }
        dp[i1][i2] = false;
        return false;
    }
}