package leetcode._39;

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


