package leetcode._153;

class Solution {
    public int findMin(int[] nums) {
        int i = 0, j = nums.length - 1;
        for (; i < j; ) {
            int m = (i + j) / 2;
            if (nums[m] < nums[j]) {
                j = m;
            } else {
                i = m + 1;
            }
        }
        return nums[i];
    }
}

class Solution1 {
    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length - 1);
    }

    private int findMin(int[] nums, int i, int j) {
        if (i == j) {
            return nums[i];
        }
        int m = (i + j) / 2;
        if (nums[m] < nums[j]) {
            return findMin(nums, i, m);
        } else {
            return findMin(nums, m + 1, j);
        }
    }
}
