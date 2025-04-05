package leetcode._162;

class Solution {
    public int findPeakElement(int[] nums) {
        int i = 0, j = nums.length - 1;
        for (; i <= j; ) {
            int m = (i + j) / 2, mid = nums[m];
            int left = m - 1 < 0 ? Integer.MIN_VALUE : nums[m - 1];
            int right = m + 1 >= nums.length ? Integer.MIN_VALUE : nums[m + 1];
            if (left < mid && mid > right) {
                return m;
            }
            if (left > mid && mid > right) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return 0;
    }
}
