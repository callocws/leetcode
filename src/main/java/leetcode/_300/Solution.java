package leetcode._300;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length, A[] = new int[n], i, cnt = 1;
        for(A[0] = i = 1; i < n; i++) {
            int t = 0;
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    t = Math.max(t, A[j]);
                }
            }
            A[i] = t + 1;
            cnt = Math.max(cnt, A[i]);
        }
        return cnt;
    }
}