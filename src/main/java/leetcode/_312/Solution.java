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