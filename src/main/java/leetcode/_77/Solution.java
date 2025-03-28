package leetcode._77;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    List<List<Integer>> result = new ArrayList();

    public List<List<Integer>> combine(int n, int k) {
        combine(1, n, k, new LinkedList());
        return result;
    }

    void combine(int i, int n, int k, List<Integer> list) {
        if (k == 0) {
            result.add(new ArrayList(list));
            return;
        }
        for (; i <= n; i++) {
            list.add(i);
            combine(i + 1, n, k - 1, list);
            list.removeLast();
        }
    }
}
