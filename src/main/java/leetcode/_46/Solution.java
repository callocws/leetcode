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
        if (n == A.length) {
            l.add(new LinkedList(r));
        }

        for (int i = 0; i < A.length; i++) {
            int t = A[i];
            if (t == 100) {
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

class Solution1 {
    List<List<Integer>> result = new LinkedList<List<Integer>>();
    boolean[] visited;

    public List<List<Integer>> permute(int[] nums) {
        visited = new boolean[nums.length];
        permute(0, nums, new LinkedList());
        return result;
    }

    void permute(int i, int[] nums, List<Integer> list) {
        if (i == nums.length) {
            result.add(new LinkedList(list));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (!visited[j]) {
                visited[j] = true;
                list.add(nums[j]);
                permute(i + 1, nums, list);
                list.removeLast();
                visited[j] = false;
            }
        }
    }
}
