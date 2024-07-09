package leetcode._312;

class Solution {
    boolean visited[] = new boolean[300];
    public int maxCoins(int[] nums) {
        int m = 0;
        for(int i = 0; i < nums.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                m = Math.max(m, mul(nums, i) + maxCoins(nums));
                visited[i] = false;
            }
        }
        return m;
    }

    int mul(int[] nums, int i) {
        int j, r;
        for(j = i - 1; j >= 0 && visited[j]; j--) {}
        for(r = i + 1; r < nums.length && visited[r]; r++) {}
        return nums[i] * (j == -1 ? 1 : nums[j]) * (r == nums.length ? 1 : nums[r]);
    }
}


class Solution1 {
    Integer dp[][] = new Integer[302][302];
    public int maxCoins(int[] nums) {
        int dumyNums[] = new int[nums.length + 2];
        for(int i = 1; i <= nums.length; i++) {
            dumyNums[i] = nums[i - 1];
        }
        dumyNums[0] = dumyNums[nums.length + 1] = 1;
        return maxCoins(dumyNums, 1, nums.length);
    }

    int maxCoins(int[] nums, int i, int j) {
        int m = 0;
        if(dp[i][j] != null) {
            return dp[i][j];
        }
        for(int k = i; k <= j; k++) {
            m = Math.max(m, nums[i - 1] * nums[k] * nums[j + 1] + maxCoins(nums, i, k - 1) + maxCoins(nums, k + 1, j));
        }
        return dp[i][j] = m;
    }

    public static void main(String[] args) {
//        int[] nums = {3,1,5,8};
        int[] nums = {3,1,2};
        int x = new Solution1().maxCoins(nums);
        System.out.println(x);

    }
}


