package leetcode._53;

class Solution {
    public int maxSubArray(int[] nums) {
        int t = 0, m = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            t = Math.max(t, 0) + nums[i];
            m = Math.max(t, m);
        }
        return m;
    }
}
