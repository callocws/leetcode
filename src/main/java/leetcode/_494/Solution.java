package leetcode._494;

import java.util.HashMap;

class Solution {
    HashMap<String, Integer> dp = new HashMap();

    public int findTargetSumWays(int[] nums, int target) {
        return calcWays(nums, 0, target);
    }

    int calcWays(int[] nums, int index, int target) {
        if (index >= nums.length) {
            if (target == 0) {
                return 1;
            }
            return 0;
        }
        String key = index + "-" + target;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        int s = calcWays(nums, index + 1, target - nums[index]);
        s += calcWays(nums, index + 1, target + nums[index]);
        dp.put(key, s);
        return s;
    }
}

class Solution1 {
    Integer dp[][];

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0, tmp;
        for (int num : nums) {
            sum += num;
        }
        tmp = sum + target;
        if (tmp % 2 != 0 || tmp < 0) {
            return 0;
        }
        dp = new Integer[nums.length][tmp / 2 + 1];
        return findTargetSumWays(nums, 0, tmp / 2);
    }

    public int findTargetSumWays(int[] nums, int i, int target) {
        if (target < 0) {
            return 0;
        }
        if (i >= nums.length) {
            return target == 0 ? 1 : 0;
        }
        if (dp[i][target] != null) {
            return dp[i][target];
        }
        return dp[i][target] =
                findTargetSumWays(nums, i + 1, target - nums[i])
                        + findTargetSumWays(nums, i + 1, target);
    }
}
