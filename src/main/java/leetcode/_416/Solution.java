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

class Solution1 {
    public boolean canPartition(int[] nums) {
        int n = 0;
        for(int i = 0; i < nums.length; i++) {
            n += nums[i];
        }

        if(n % 2 == 1) {
            return false;
        }

        n >>= 1;
        int[][] q = new int[nums.length + 1][n + 1];
        q[0][n] = 1;
        for(int i = 1; i <= nums.length; i++) {
            for(int j = n; j >= 0; j--) {
                if(q[i - 1][j] == 1) {
                    q[i][j] = 1;
                    if(j - nums[i - 1] >= 0) {
                        q[i][j - nums[i - 1]] = 1;
                    }
                }
            }
        }
        return q[nums.length][0] == 1;
    }
}

class Solution2 {
    public boolean canPartition(int[] nums) {
        int n = 0;
        for(int i = 0; i < nums.length; i++) {
            n += nums[i];
        }
        if(n % 2 == 1) {
            return false;
        }
        n >>= 1;
        boolean[] q = new boolean[n + 1];
        q[n] = true;
        for(int num : nums) {
            for(int j = 0; j <= n - num; j++) {
                q[j] = q[j] || q[j + num];
            }
        }
        return q[0];
    }
}