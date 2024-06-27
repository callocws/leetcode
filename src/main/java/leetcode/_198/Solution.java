package leetcode._198;

class Solution {
    public int rob(int[] nums) {
        int a, b, i, m;
        for(a = m = 0, b = nums[0], i = 1; i < nums.length; i++) {
            m = Math.max(m, a);
            int t = m + nums[i];
            a = b;
            b = t;
        }
        return Math.max(a, b);
    }
}