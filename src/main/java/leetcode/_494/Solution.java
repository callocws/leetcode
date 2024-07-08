package leetcode._494;

import java.util.HashMap;

class Solution {
    HashMap<String, Integer> dp = new HashMap();
    public int findTargetSumWays(int[] nums, int target) {
        return calcWays(nums, 0, target);
    }
    int calcWays(int[] nums, int index, int target) {
        if(index >= nums.length) {
            if(target == 0) {
                return 1;
            }
            return 0;
        }
        String key = index+"-"+target;
        if(dp.containsKey(key)) {
            return dp.get(key);
        }
        int s = calcWays(nums, index + 1, target - nums[index]);
        s += calcWays(nums, index + 1, target + nums[index]);
        dp.put(key, s);
        return s;
    }
}