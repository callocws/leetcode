package leetcode._15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


// 15. 3Sum
// tle
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> r = new LinkedList();
        HashMap<Integer, Integer> m = new HashMap();
        Set<List<Integer>> s = new HashSet();

        for(int i = 0; i < nums.length; i++) {
            m.put(nums[i], m.getOrDefault(nums[i], 0) + 1);
        }

        for(int i = 0; i < nums.length; i++) {
            m.put(nums[i], m.get(nums[i]) - 1);
            for(int j = 0; j < nums.length; j++) {
                if(m.get(nums[j]) > 0) {
                    List<Integer> l = new LinkedList<Integer>();
                    m.put(nums[j], m.get(nums[j]) - 1);
                    if(m.getOrDefault(0 - nums[i] - nums[j], 0) > 0) {
                        s.add(seq(nums[i], nums[j], 0 - nums[i] - nums[j]));
                    }
                    m.put(nums[j], m.get(nums[j]) + 1);
                }
            }
            m.put(nums[i], m.get(nums[i]) + 1);
        }
        r.addAll(s);
        return r;
    }

    List<Integer> seq(int a, int b, int c) {
        List<Integer> l = new ArrayList(List.of(a, b, c));
        l.sort(null);
        return l;
    }
}

class Solution1 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> r = new LinkedList();
        Set<List<Integer>> s = new HashSet();

        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1, t = nums.length - 1; j < t;) {
                int k = nums[j] + nums[t];
                if(k == 0 - nums[i]) {
                    s.add(List.of(nums[i], nums[j++], nums[t--]));
                } else if (k < 0 - nums[i]) {
                    j++;
                } else {
                    t--;
                }
            }
        }

        r.addAll(s);
        return r;
    }
}
