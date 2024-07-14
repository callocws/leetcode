package leetcode._1060;


//  Missing Element in Sorted Array
public class Solution {
    public int missingElement(int[] nums, int k) {
        int cnt = 0, i = 0, j = nums[0];
        for(; i < nums.length; j++) {
            if(nums[i] == j) {
                i++;
            } else if(nums[i] > j) {
                cnt++;
                if(cnt == k) {
                    return j;
                }         
            }
        }
        return j + k - cnt - 1;
    }
}

class Solution1 {
    public int missingElement(int[] nums, int k) {
        int l, r, m;
        m = l = 0; r = nums.length - 1;
        if(nums[r] - r - nums[0] < k) {
            return r + nums[0] + k;
        }
        for(; l < r; ) {
            m = (l + r) >> 1;
            if(nums[m] - m - nums[0] >= k) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return --r + nums[0] + k;
    }
}