package leetcode._90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Solution {
    HashSet<List<Integer>> s = new HashSet();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        traverse(new LinkedList(), nums, 0);
        return new LinkedList(s);
    }

    void traverse(List<Integer> r, int[] A, int i) {
        s.add(new LinkedList(r));
        for (; i < A.length; i++) {
            r.add(A[i]);
            traverse(r, A, i + 1);
            r.removeLast();
        }
    }
}

class Solution1 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        return new ArrayList(add(0, nums));
    }

    Set<List<Integer>> add(int i, int[] nums) {
        Set<List<Integer>> result = new HashSet();
        if (i == nums.length) {
            result.add(new ArrayList());
        } else {
            var nextResult = add(i + 1, nums);
            for (var list : nextResult) {
                var copy = new ArrayList(list);
                copy.add(nums[i]);
                result.add(copy);
            }
            result.addAll(nextResult);
        }
        return result;
    }
}

class Solution2 {
    LinkedList<List<Integer>> l = new LinkedList();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        traverse(new LinkedList(), nums, 0);
        return l;
    }

    void traverse(List<Integer> r, int[] A, int i) {
        l.add(new LinkedList(r));
        for (int j = i; j < A.length; j++) {
            if (j > i && A[j] == A[j - 1]) {
                continue;
            }
            r.add(A[j]);
            traverse(r, A, j + 1);
            r.removeLast();
        }
    }
}
