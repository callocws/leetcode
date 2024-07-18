package leetcode._410;

class Solution {
    Integer dp[][];
    public int splitArray(int[] nums, int k) {
        dp = new Integer[nums.length + 1][k + 1];
        return splitArray(nums, 0, k - 1);
    }

    public int splitArray(int[] nums, int i, int k) {
        if(dp[i][k] != null) {
            return dp[i][k];
        }
        if(k <= 0) {
            int s = 0;
            for(int j = i; j < nums.length; j++) {
                s += nums[j];
            }
            return dp[i][k] = s;
        }
        int l = 0, r, m = Integer.MAX_VALUE;
        for(int j = i; j < nums.length; j++) {
            l += nums[j];
            r = splitArray(nums, j + 1, k - 1);
            m = Math.min(m, Math.max(l, r));
            if (l > r) {
                break;
            }
        }
        return dp[i][k] = m;
    }
}

class Solution1 {
    public int splitArray(int[] nums, int k) {
        int l = 0, r = 0;
        for(int i = 0; i < nums.length; i++) {
            l = Math.max(l, nums[i]);
            r += nums[i];
        }
        for(;l < r;) {
            int m = l + (r - l) / 2, cnt = 1, s = 0;
            for(int i = 0; i < nums.length && cnt <= k; i++) {
                if(s + nums[i] <= m) {
                    s += nums[i];
                } else {
                    cnt++;
                    s = nums[i];
                }
            }
            if(cnt <= k) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}