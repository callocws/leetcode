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

class Solution1 {
    public int rob(int[] nums) {
        int a, b, i;
        for(a = 0, b = nums[0], i = 1; i < nums.length; i++) {
            int t = Math.max(a + nums[i], b);
            a = b;
            b = t;
        }
        return b;
    }
}