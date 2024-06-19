package leetcode._90;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

class Solution {
    HashSet<List<Integer>> s = new HashSet();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        traverse(new LinkedList(), nums, 0);
        return new LinkedList(s);
    }
    void traverse(List<Integer> r, int[] A, int i) {
        s.add(new LinkedList(r));
        for(; i < A.length; i++) {
            r.add(A[i]);
            traverse(r, A, i + 1);
            r.removeLast();        
        }
    }
}