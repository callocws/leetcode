package leetcode._80;

class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 1, j = 0, cnt = 1;
        for (; i < nums.length; i++) {
            if (nums[i] == nums[j]) {
                if (cnt == 1) {
                    nums[++j] = nums[i];
                }
                cnt++;
            } else {
                nums[++j] = nums[i];
                cnt = 1;
            }
        }
        return j + 1;
    }
}
