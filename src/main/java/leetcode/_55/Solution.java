package leetcode._55;

class Solution {
    public boolean canJump(int[] nums) {
        boolean dp[] = new boolean[nums.length];
        dp[0] = true;
        for(int i = 0; i < nums.length; i++) {
            for(int j = 1; dp[i] && j <= nums[i]; j++) {
                if(i + j < nums.length) {
                    dp[i + j] = true;
                }
            }
        }
        return dp[nums.length - 1];
    }
}

class Solution1 {
    public boolean canJump(int[] nums) {
        int j = nums.length - 1;
        for(int i = j - 1; i >= 0; i--) {
            if(i + nums[i] >= j) {
                j = i;
            }
        }
        return j == 0;
    }
}