package leetcode._322;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] A = new int[amount + 1];
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= amount) {
                A[coins[i]] = 1;
            }
        }
        for (int i = 0; i < A.length; i++) {
            int t = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                int x = i - coins[j];
                if (x >= 0 && A[x] > 0) {
                    t = Math.min(t, A[x]);
                }
            }
            if (t < Integer.MAX_VALUE && A[i] == 0) {
                A[i] += t + 1;
            }
        }
        return amount == 0 ? 0 : A[amount] == 0 ? -1 : A[amount];
    }
}

class Solution1 {
    public int coinChange(int[] coins, int amount) {
        int[] A = new int[amount + 1];
        for (int i = 1; i < A.length; i++) {
            A[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                int x = i - coins[j];
                if (x >= 0 && A[x] < Integer.MAX_VALUE) {
                    A[i] = Math.min(A[i], 1 + A[x]);
                }
            }
        }
        return amount == 0 ? 0 : A[amount] == Integer.MAX_VALUE ? -1 : A[amount];
    }
}

class Solution2 {
    public int coinChange(int[] coins, int amount) {
        Integer[] dp = new Integer[amount + 1];
        return coinChange(coins, dp, amount);
    }

    int coinChange(int[] coins, Integer[] dp, int target) {
        if (target < 0) {
            return -1;
        }
        if (target == 0) {
            return 0;
        }
        if (dp[target] != null) {
            return dp[target];
        }
        int s = Integer.MAX_VALUE;
        for (int c : coins) {
            int k = coinChange(coins, dp, target - c);
            if (target - c >= 0 && k >= 0) {
                s = Math.min(s, 1 + k);
            }
        }
        return dp[target] = s == Integer.MAX_VALUE ? -1 : s;
    }
}
