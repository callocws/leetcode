package leetcode._518;

// wrong, it calculates a duplicate number of ways to make change with the coins
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        for(int i = 0; i < coins.length; i++) {
            dp[coins[i]]++;
        }
        for(int i = coins[0]; i < dp.length; i++) {
            for(int j = 0; j < coins.length; j++) {
                dp[i] += i - coins[j] < 0 ? 0 : dp[i - coins[j]];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().change(5, new int[]{1, 2, 5}));
    }
}