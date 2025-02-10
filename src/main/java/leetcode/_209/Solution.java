package leetcode._209;

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i, j, m = Integer.MAX_VALUE, sum = 0;
        for (i = j = 0; j < nums.length; j++) {
            sum += nums[j];
            for (; sum >= target; sum -= nums[i++]) {
                m = Math.min(m, j - i + 1);
            }
        }
        return m == Integer.MAX_VALUE ? 0 : m;
    }
}
