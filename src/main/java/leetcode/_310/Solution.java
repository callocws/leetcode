package leetcode._310;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> adj[] = new ArrayList[n], q = new ArrayList(), r = new ArrayList();
        int degree[] = new int[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList();
        }
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        for (int i = 0; i < n; i++) {
            degree[i] = adj[i].size();
            if (degree[i] == 1) {
                q.add(i);
            }
        }
        for (int i = 0; i < q.size(); ) {
            int t = q.size();
            r = new ArrayList<>(q.subList(i, t));
            for (; i < t; i++) {
                int index = q.get(i);
                degree[index]--;
                for (int j : adj[index]) {
                    degree[j]--;
                    if (degree[j] == 1) {
                        q.add(j);
                    }
                }
            }
        }

        return r.isEmpty() ? List.of(0) : r;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findMinHeightTrees(4, new int[][] {{1, 0}, {1, 2}, {1, 3}}));
        System.out.println(s.findMinHeightTrees(2, new int[][] {{0, 1}}));
    }
}
