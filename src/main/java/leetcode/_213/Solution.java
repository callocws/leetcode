package leetcode._213;

class Solution {
    public int rob(int[] nums) {
        int a, b, i, n = nums.length, m = 0;
        if(n == 1) {
            return nums[0];
        }
        for(a = 0, b = nums[0], i = 1; i < n - 1; i++) {
            int t = Math.max(a + nums[i], b);
            a = b;
            b = t;
        }
        m = b;
        for(a = 0, b = nums[1], i = 2; i < n; i++) {
            int t = Math.max(a + nums[i], b);
            a = b;
            b = t;
        }
        return Math.max(m, b);
    }
}

