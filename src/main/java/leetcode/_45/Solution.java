package leetcode._45;

class Solution {
    public int jump(int[] nums) {
        int j = nums.length - 1, cnt = 0;
        for (;j != 0;) {
            int t = j;
            for(int i = j - 1; i >= 0; i--) {
                if(i + nums[i] >= j) {
                    t = i;
                }
            }
            j = t;
            cnt++;
        }

        return cnt;
    }
}

