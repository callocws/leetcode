package leetcode._137;

class Solution {
    public int singleNumber(int[] nums) {
        int x = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int num : nums) {
                sum += (num >>> i) & 1;
            }
            x += (sum % 3) << i;
        }
        return x;
    }
}
