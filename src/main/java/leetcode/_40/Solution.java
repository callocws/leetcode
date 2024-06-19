package leetcode._40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    ArrayList<List<Integer>> r = new ArrayList();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        traverse(candidates, target, 0, new ArrayList());
        return r;
    }

    void traverse(int[] A, int remain, int i, List<Integer> l) {
        if(remain == 0) {
            r.add(new ArrayList(l));
        }
        for(int j = i; j < A.length; j++) {
            if(j > i && A[j] == A[j - 1]) {
                continue;
            }
            if(remain < A[j]) {
                return;
            }
            l.add(A[j]);
            traverse(A, remain - A[j], j + 1, l);
            l.removeLast();
        }
    }
}