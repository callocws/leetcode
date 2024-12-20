package leetcode._210;

import java.util.ArrayList;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> adj[] = new ArrayList[numCourses], q = new ArrayList();
        int[] d = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList();
        }
        for (int[] p : prerequisites) {
            adj[p[1]].add(p[0]);
            d[p[0]]++;
        }
        for (int i = 0; i < numCourses; i++) {
            if (d[i] == 0) {
                q.add(i);
            }
        }
        for (int i = 0; i < q.size(); i++) {
            int start = q.get(i);
            for (int j = 0; j < adj[start].size(); j++) {
                int end = adj[start].get(j);
                if (--d[end] == 0) {
                    q.add(end);
                }
            }
        }
        int result[] = new int[q.size() != numCourses ? 0 : numCourses];
        for (int i = 0; i < result.length; i++) {
            result[i] = q.get(i);
        }
        return result;
    }
}
