package leetcode._518;

class Solution {
    Integer dp[][];

    public int change(int amount, int[] coins) {
        dp = new Integer[coins.length][amount + 1];
        return calculate(0, amount, coins);
    }

    int calculate(int index, int target, int[] coins) {
        if (target == 0) {
            return 1;
        }
        if (index >= coins.length) {
            return 0;
        }
        if (dp[index][target] != null) {
            return dp[index][target];
        }
        int s = 0;
        for (int i = 0; i * coins[index] <= target; i++) {
            s += calculate(index + 1, target - i * coins[index], coins);
        }
        return dp[index][target] = s;
    }
}

// wrong, it calculates a duplicate number of ways to make change with the coins
class Solutionx {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        for (int i = 0; i < coins.length; i++) {
            dp[coins[i]]++;
        }
        for (int i = coins[0]; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                dp[i] += i - coins[j] < 0 ? 0 : dp[i - coins[j]];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(new Solutionx().change(5, new int[] {1, 2, 5}));
    }
}
