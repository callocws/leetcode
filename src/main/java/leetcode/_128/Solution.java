package leetcode._128;

import java.util.HashMap;
import java.util.HashSet;

//https://leetcode.com/problems/longest-consecutive-sequence/solutions/41057/simple-o-n-with-explanation-just-walk-each-streak
// 128. Longest Consecutive Sequence

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> s = new HashSet();
        for (int num : nums) {
            s.add(num);
        }

        int k = 0;
        for(int i = 0; i < nums.length; i++) {
            if(s.contains(nums[i] - 1)) { // avoid duplicate
                continue;
            }
            for(int t = 0; s.contains(nums[i] + t); ) {
                t++;
                k = Math.max(k, t);
            }
        }
        return k;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
}

class Solution1 {
    HashMap<Integer, Integer> map = new HashMap();

    public int longestConsecutive(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        int cnt = 0;
        for(int i = 0; i < nums.length; i++) {
            cnt = Math.max(-1 * putAndGet(nums[i]), cnt);
        }
        return cnt;
    }

    int putAndGet(int v) {
        Integer index = map.get(v);
        if(index == null) {
            return 0;
        }
        if(index < 0) {
            return index;
        }
        int cnt = -1 + putAndGet(v + 1);
        map.put(v, cnt);
        return cnt;
    }
}