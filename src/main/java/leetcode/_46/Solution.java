package leetcode._46;

import java.util.LinkedList;
import java.util.List;

class Solution {
    LinkedList<List<Integer>> l = new LinkedList();
    public List<List<Integer>> permute(int[] nums) {
        f(new LinkedList(), nums, 0);
        return l;
    }

    void f(List<Integer> r, int[] A, int n) {
        if(n == A.length) {
            l.add(new LinkedList(r));
        }

        for(int i = 0; i < A.length; i++) {
            int t = A[i];
            if(t == 100) {
                continue;
            }
            A[i] = 100;
            r.add(t);
            f(r, A, n + 1);
            r.removeLast();
            A[i] = t;
        }
    }
}