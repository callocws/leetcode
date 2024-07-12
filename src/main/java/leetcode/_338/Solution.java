package leetcode._338;

class Solution {
    public int[] countBits(int n) {
        int nums[] = new int[n + 1];
        for(int i = 1, t = 1; i < n + 1; i++) {
            if(i == 2 * t) {
                t *= 2;
            }
            nums[i] = 1 + nums[i - t];
        }
        return nums;
    }
}

class Solution1 {
    public int[] countBits(int n) {
        int nums[] = new int[n + 1];
        for(int i = 1; i < n + 1; i++) {
            nums[i] = nums[i >> 1] + (i & 1);
        }
        return nums;
    }
}