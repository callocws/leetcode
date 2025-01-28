package leetcode._309;

import java.util.HashMap;

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length, s[][] = new int[3][n + 1], i = 1;
        for (s[0][0] = s[2][0] = 0, s[1][0] = -prices[0]; i <= n; i++) {
            s[0][i] = Math.max(s[0][i - 1], s[2][i - 1]);
            s[1][i] = Math.max(s[1][i - 1], s[0][i - 1] - prices[i - 1]);
            s[2][i] = s[1][i - 1] + prices[i - 1];
        }
        return Math.max(s[0][n], s[2][n]);
    }
}

class Solution1 {
    int n;
    int[] prices;
    HashMap<String, Integer> m = new HashMap();

    public int maxProfit(int[] prices) {
        n = prices.length;
        this.prices = prices;
        return maxProfit(0, true);
    }

    int maxProfit(int i, boolean buyAvailable) {
        if (i >= n) {
            return 0;
        }
        String key = "" + i + buyAvailable;
        if (m.containsKey(key)) {
            return m.get(key);
        }
        int c = maxProfit(i + 1, buyAvailable), t;
        if (buyAvailable) {
            t = maxProfit(i + 1, false) - prices[i];
        } else {
            t = maxProfit(i + 2, true) + prices[i];
        }
        int v = Math.max(c, t);
        m.put(key, v);
        return v;
    }
}

class Solution2 {
    Integer[][] dp;

    public int maxProfit(int[] prices) {
        dp = new Integer[prices.length][3];
        return maxProfit(0, 2, prices);
    }

    // 0: buy, 1: sell, 2: cool
    int maxProfit(int i, int lastStatus, int[] prices) {
        if (i >= prices.length) {
            return 0;
        }
        if (dp[i][lastStatus] != null) {
            return dp[i][lastStatus];
        }
        int profit = 0;
        if (lastStatus == 2) {
            profit = Math.max(maxProfit(i + 1, 0, prices) - prices[i], maxProfit(i + 1, 2, prices));
        }
        if (lastStatus == 0) {
            profit = Math.max(maxProfit(i + 1, 1, prices) + prices[i], maxProfit(i + 1, 0, prices));
        }
        if (lastStatus == 1) {
            profit = maxProfit(i + 1, 2, prices);
        }
        return dp[i][lastStatus] = profit;
    }
}
