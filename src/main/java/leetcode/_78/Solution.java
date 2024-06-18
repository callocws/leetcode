package leetcode._78;

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
        for(; i < A.length; i++) {
            LinkedList<Integer> c = new LinkedList(B);
            c.add(A[i]);
            l.add(c);
            f(new LinkedList(c), A, i + 1);
        }
    }
}