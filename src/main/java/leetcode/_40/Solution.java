package leetcode._40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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

class Solution1 { // timeout
    Set<List<Integer>> r = new HashSet<List<Integer>>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationSum2(new LinkedList(), 0, candidates, target);
        return new LinkedList(r);
    }

    void combinationSum2(List<Integer> list, int i, int[] candidates, int target) {
        list = new LinkedList(list);
        if(target == 0) {
            r.add(list);
            return;
        }
        if(i == candidates.length) {
            return;
        }
        combinationSum2(list, i + 1, candidates, target);
        list.add(candidates[i]);
        combinationSum2(list, i + 1, candidates, target - candidates[i]);
    }
}

class Solution2 { // timeout
    Set<List<Integer>> r = new HashSet<List<Integer>>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationSum2(new LinkedList(), 0, candidates, target);
        return new LinkedList(r);
    }

    void combinationSum2(List<Integer> list, int i, int[] candidates, int target) {
        if(target == 0) {
            r.add(new LinkedList(list));
            return;
        }
        for(int j = i; j < candidates.length; j++) {
            int t = target - candidates[j];
            if (t < 0) {
                return;
            }
            list.add(candidates[j]);
            combinationSum2(list, j + 1, candidates, t);
            list.removeLast();
        }
    }
}



