package leetcode._678;

class Solution {
    public boolean checkValidString(String s) {
        char cs[] = s.toCharArray();
        return f(cs, 0, 0);
    }

    boolean f(char cs[], int i, int n) {
        if(n < 0) {
            return false;
        }
        if(i == cs.length) {
            return n == 0;
        }
        if(cs[i] == '(') {
            return f(cs, i + 1, n + 1);
        } else if(cs[i] == ')') {
            return f(cs, i + 1, n - 1);
        }
        return  f(cs, i + 1, n) || f(cs, i + 1, n - 1) || f(cs, i + 1, n + 1);
    }
}

class Solution1 {
    public boolean checkValidString(String s) {
        char cs[] = s.toCharArray();
        boolean dp[][] = new boolean[cs.length + 1][cs.length + 1];
        dp[0][0] = true;
        for(int i = 0; i < dp.length - 1; i++) {
            for(int j = 0; j < dp.length; j++) {
                if(dp[i][j]) {
                    if(cs[i] == '(') {
                        dp[i + 1][j + 1] = true;
                    } else if(cs[i] == ')' && j - 1 >= 0) {
                        dp[i + 1][j - 1] = true;
                    } else if(cs[i] == '*'){
                        dp[i + 1][j] = true;
                        if(j - 1 >= 0) {
                            dp[i + 1][j - 1] = true;
                        }
                        dp[i + 1][j + 1] = true;
                    }
                }
            }
        }
        return dp[cs.length][0];
    }
}