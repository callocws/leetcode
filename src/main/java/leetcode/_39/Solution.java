package leetcode._39;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {

    LinkedList<List<Integer>> l = new LinkedList();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        f(candidates, target, 0, 0, new LinkedList());
        return l;
    }
    void f(int[] A, int target, int i, int s, List<Integer> r) {
        if(target == s) {
            l.add(new LinkedList(r));
            return;
        }
        for(; i < A.length; i++) {
            int j = 1;
            for(; s + j * A[i] <= target; j++) {
                r.add(A[i]);
                f(A, target, i + 1, s + j * A[i], r);
            }
            for(int t = 1; t < j; t++) {
                r.removeLast();
            }
        }
    }
}


class Solution1 {
    List<List<Integer>> r = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combine(0, target, candidates, new LinkedList());
        return r;
    }

    void combine(int i, int target, int[] candidates, List<Integer> nums) {
        if(target == 0) {
            r.add(new ArrayList(nums));
            return;
        }
        if(i >= candidates.length) {
            return;
        }
        nums = new LinkedList(nums);
        for(int j = 0; target - candidates[i] * j >= 0; j++) {
            combine(i + 1, target - candidates[i] * j, candidates, nums);
            nums.add(candidates[i]);
        }
    }
}

