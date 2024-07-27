package leetcode._1004;

class Solution {
    Integer[][] dp;
    public int longestOnes(int[] nums, int k) {
        dp = new Integer[nums.length + 1][k + 1]; 
        int t = 0;
        for(int i = 0; i < nums.length; i++) {
            t = Math.max(t, longestOnes(nums, i, k));
        }
        return t;
    }

    int longestOnes(int[] nums, int index, int k) {
        if(index < 0 || k == 0 && nums[index] == 0) {
            return 0;
        }
        if(dp[index][k] != null) {
            return dp[index][k];
        }
        int t = 1;
        if(nums[index] == 0) {
            t += longestOnes(nums, index - 1, k - 1);
        } else {
            t += longestOnes(nums, index - 1, k);
        }
        return dp[index][k] = t;
    }
}

class Solution1 {
    public int longestOnes(int[] nums, int k) {
        int dp[][] = new int[2][nums.length + 1], t = 0;
        for(int i = 0; i <= k; i++) {
            for(int j = 1; j <= nums.length; j++) {
                if(nums[j - 1] == 0) {
                    dp[1][j] = i == 0 ? 0 : dp[0][j - 1] + 1;
                } else {
                    dp[1][j] = dp[1][j - 1] + 1;
                }
            }
            for(int j = 1; j <= nums.length; j++) {
                t = Math.max(t, dp[0][j] = dp[1][j]);
            }
        }
        return t;
    }
}


class Solution2 {
    public int longestOnes(int[] nums, int k) {
        int dp[] = new int[k + 1], t = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = k; j > 0; j--) {
                if(nums[i] == 0) {
                    dp[j] = dp[j - 1] + 1;
                } else {
                    dp[j] = dp[j] + 1;
                }
            }
            dp[0] = nums[i] == 0 ? 0 : (dp[0] + 1);
            t = Math.max(t, dp[k]);
        }
        return t;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().longestOnes(new int[]{0,0,1,1}, 3));
    }
}

class Solution3 {
    public int longestOnes(int[] nums, int k) {
        int l = -1, r = 0, max = 0, cnt = 0;
        for(;r < nums.length;) {
            if(nums[r] == 1) {
                r++;
            } else {
                if(cnt < k) {
                    cnt++;
                    r++;
                } else {
                    for(;nums[++l] != 0;) {}
                    cnt--;
                }
            }
            max = Math.max(max, r - l - 1);
        }
        return max;
    }
}