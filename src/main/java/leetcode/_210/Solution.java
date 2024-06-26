package leetcode._210;

import java.util.ArrayList;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> l[] = new ArrayList[numCourses], q = new ArrayList(), r = new ArrayList();
        int[] d = new int[numCourses];

        for(int i = 0; i < numCourses; i++) {
            l[i] = new ArrayList();
        }
        for(int[] p : prerequisites) {
            l[p[1]].add(p[0]);
            d[p[0]]++;
        }
        for(int i = 0; i < numCourses; i++) {
            if(d[i] == 0) {
                q.add(i);
            }
        }
        for(int i = 0; i < q.size(); i++) {
            int start = q.get(i);
            r.add(start);
            for(int j = 0; j < l[start].size(); j++) {
                int end = l[start].get(j);
                if(--d[end] == 0) {
                    q.add(end);
                }
            }
        }
        int re[] = new int[q.size() != numCourses? 0 : numCourses];
        for(int i = 0; i < re.length; i++) {
            re[i] = q.get(i);
        }
        return re;
    }
}