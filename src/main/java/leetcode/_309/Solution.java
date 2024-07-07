package leetcode._309;

import java.util.HashMap;

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

class Solution1 {
    int n;
    int[] prices;
    HashMap<String, Integer> m = new HashMap();
    public int maxProfit(int[] prices) {
        n = prices.length;
        this.prices = prices;
        return f(0, true);
    }

    int f(int i, boolean buyavail) {
        if(i >= n) {
            return 0;
        }
        String key = ""+i+buyavail;
        if(m.containsKey(key)) {
            return m.get(key);
        }
        int c = f(i + 1, buyavail), t;
        if(buyavail) {
            t = f(i + 1, false) - prices[i];
        } else {
            t = f(i + 2, true) + prices[i];
        }
        int v = Math.max(c, t);
        m.put(key, v);
        return v;
    }
}

