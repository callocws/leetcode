package leetcode._918;

class Solution {
    int sum = 0;
    int min = 0;
    int max;

    public int maxSubarraySumCircular(int[] nums) {
        max = nums[0];
        traverseMin(0, nums);
        traverseMax(0, nums);
        int t = sum - min;
        t = t == 0 ? Integer.MIN_VALUE : t;
        return Math.max(t, max);
    }

    int traverseMin(int i, int[] nums) {
        if (i >= nums.length) {
            return 0;
        }
        sum += nums[i];
        int s = Math.min(nums[i] + traverseMin(i + 1, nums), 0);
        min = Math.min(min, s);
        return s;
    }

    int traverseMax(int i, int[] nums) {
        if (i >= nums.length) {
            return 0;
        }
        int s = nums[i] + Math.max(traverseMax(i + 1, nums), 0);
        max = Math.max(max, s);
        return s;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxSubarraySumCircular(new int[] {-3, -2, -3}));
    }
}
