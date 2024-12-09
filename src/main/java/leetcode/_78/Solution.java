package leetcode._78;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    LinkedList<List<Integer>> l = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        l.add(List.of());
        f(List.of(), nums, 0);
        return l;
    }

    void f(List<Integer> B, int[] A, int i) {
        for (; i < A.length; i++) {
            LinkedList<Integer> c = new LinkedList(B);
            c.add(A[i]);
            l.add(c);
            f(new LinkedList(c), A, i + 1);
        }
    }
}

class Solution1 {

    public List<List<Integer>> subsets(int[] nums) {
        return add(0, nums);
    }

    List<List<Integer>> add(int i, int[] nums) {
        List<List<Integer>> result = new ArrayList();
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
