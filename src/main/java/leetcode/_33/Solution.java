package leetcode._33;

class Solution {
    public int search(int[] nums, int target) {
        int i = 0, j = nums.length - 1, n = nums.length;
        for (; i < j; ) {
            int m = (i + j) / 2;
            if (nums[m] < nums[j]) {
                j = m;
            } else {
                i = m + 1;
            }
        }

        int k = i;
        for (i = 0, j = nums.length - 1; i <= j; ) {
            int m = (i + j) / 2;
            m = (m + k) % n;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] < target) {
                i = (m + n - k) % n + 1;
            } else {
                j = (m + n - k) % n - 1;
            }
        }
        return -1;
    }
}

class Solution1 {
    public int search(int[] nums, int target) {
        int i = 0, j = nums.length - 1, n = nums.length;
        for (; i < j; ) {
            int m = (i + j) / 2;
            if (nums[m] < nums[j]) {
                j = m;
            } else {
                i = m + 1;
            }
        }

        int k = i;
        for (i = 0, j = nums.length; i < j; ) {
            int m = (i + j) / 2, m1 = (m + k) % n;
            if (nums[m1] == target) {
                return m1;
            } else if (nums[m1] < target) {
                i = m + 1;
            } else {
                j = m;
            }
        }
        return -1;
    }
}
