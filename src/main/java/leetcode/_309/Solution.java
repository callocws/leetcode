package leetcode._309;

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length, s[][] = new int[3][n + 1], i = 1;
        for(s[0][0] = s[2][0] = 0, s[1][0] = -prices[0]; i <= n; i++) {
            s[0][i] = Math.max(s[0][i - 1], s[2][i - 1]);
            s[1][i] = Math.max(s[1][i - 1], s[0][i - 1] - prices[i - 1]);
            s[2][i] = s[1][i - 1] + prices[i - 1];
        }
        return Math.max(s[0][n], s[2][n]);
    }
}