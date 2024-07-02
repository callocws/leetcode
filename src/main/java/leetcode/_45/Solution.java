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

class Solution1 {
    public int jump(int[] nums) {
        int l, r, cnt = 0;
        for (l = r = 0; r < nums.length - 1;) {
            int t = 0;
            for (int j = l; j <= r; j++) {
                t = Math.max(t, nums[j] + j);
            }
            l = r + 1;
            r = t;
            cnt++;
        }

        return cnt;
    }
}


