package leetcode._322;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] A = new int[amount + 1];
        for(int i = 0; i < coins.length; i++) {
            if(coins[i] <= amount) {
                A[coins[i]] = 1;
            }
        }
        for(int i = 0; i < A.length; i++) {
            int t = Integer.MAX_VALUE;
            for(int j = 0; j < coins.length; j++) {
                int x = i - coins[j];
                if(x >= 0 && A[x] > 0) {
                    t = Math.min(t, A[x]);
                }
            }
            if(t < Integer.MAX_VALUE && A[i] == 0) {
                A[i] += t + 1;
            }
        }
        return amount == 0 ? 0 : A[amount] == 0 ? -1 : A[amount];
    }
}