package leetcode._746;

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int a, b, i;
        for(a = b = 0, i = 2; i <= cost.length; i++) {
            int t = Math.min(a + cost[i - 2], b + cost[i - 1]);
            a = b;
            b = t;
        }
        return b;
    }
}