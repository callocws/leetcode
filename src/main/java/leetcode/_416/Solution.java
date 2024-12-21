package leetcode._416;

class Solution {
    public boolean canPartition(int[] nums) {
        int s = 0;
        for (int i = 0; i < nums.length; i++) {
            s += nums[i];
        }
        return s % 2 == 0 && canPartition(0, s / 2, nums);
    }

    boolean canPartition(int i, int target, int[] nums) {
        if (target == 0) {
            return true;
        }
        if (i >= nums.length || target < 0) {
            return false;
        }
        return canPartition(i + 1, target, nums) || canPartition(i + 1, target - nums[i], nums);
    }
}

class Solution1 {
    public boolean canPartition(int[] nums) {
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            n += nums[i];
        }

        if (n % 2 == 1) {
            return false;
        }

        n >>= 1;
        int[][] q = new int[nums.length + 1][n + 1];
        q[0][n] = 1;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = n; j >= 0; j--) {
                if (q[i - 1][j] == 1) {
                    q[i][j] = 1;
                    if (j - nums[i - 1] >= 0) {
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
        for (int i = 0; i < nums.length; i++) {
            n += nums[i];
        }
        if (n % 2 == 1) {
            return false;
        }
        n >>= 1;
        boolean[] q = new boolean[n + 1];
        q[n] = true;
        for (int num : nums) {
            for (int j = 0; j <= n - num; j++) {
                q[j] = q[j] || q[j + num];
            }
        }
        return q[0];
    }
}
