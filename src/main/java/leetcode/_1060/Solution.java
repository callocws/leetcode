package leetcode._1060;

//  Missing Element in Sorted Array
public class Solution {
    public int missingElement(int[] nums, int k) {
        int cnt = 0, i = 0, j = nums[0];
        for (; i < nums.length; j++) {
            if (nums[i] == j) {
                i++;
            } else if (nums[i] > j) {
                cnt++;
                if (cnt == k) {
                    return j;
                }
            }
        }
        return nums[nums.length - 1] + (k - cnt);
    }
}

class Solution1 {
    public int missingElement(int[] nums, int k) {
        int cnt = 0, i = 0;
        for (; i < nums.length; i++) {
            int t = nums[i] - i - nums[0];
            if (t < k) {
                cnt = t;
            } else {
                return nums[i - 1] + (k - cnt);
            }
        }
        return nums[i - 1] + (k - cnt);
    }
}

class Solution1_2 {
    public int missingElement(int[] nums, int k) {
        int i = 0;
        for (; i < nums.length; i++) {
            if (nums[i] - i - nums[0] >= k) {
                return k + (i - 1) + nums[0];
            }
        }
        return k + (i - 1) + nums[0];
    }
}

class Solution2 {
    public int missingElement(int[] nums, int k) {
        int l = 0, r = nums.length - 1, m;
        if (nums[r] - r - nums[0] < k) {
            return r + nums[0] + k;
        }
        for (; l < r; ) {
            m = (l + r) >> 1;
            if (nums[m] - m - nums[0] >= k) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return --r + nums[0] + k;
    }
}

class Solution2_1 {
    public int missingElement(int[] nums, int k) {
        int l = 0, r = nums.length;
        for (; l < r; ) {
            int m = (l + r) >> 1;
            if (nums[m] - m - nums[0] >= k) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return --l + nums[0] + k;
    }
}

class Solution2_2 {
    public int missingElement(int[] nums, int k) {
        int l = 0, r = nums.length - 1, m;
        for (; l <= r; ) {
            m = (l + r) >> 1;
            if (nums[m] - m - nums[0] >= k) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return r + nums[0] + k;
    }
}
