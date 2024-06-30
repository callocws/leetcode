package leetcode._416;

class Solution {
    public boolean canPartition(int[] nums) {
        int n = 0;
        for(int i = 0; i < nums.length; i++) {
            n += nums[i];
        }
        return n % 2 == 0 && f(0, n / 2, nums);
    }
    boolean f(int i, int n, int[] nums) {
        if(n == 0) {
            return true;
        } 
        if(i >= nums.length || n < 0) {
            return false;
        }
        return f(i + 1, n, nums) || f(i + 1, n - nums[i], nums);
    }
}