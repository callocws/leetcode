package leetcode._1584;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

class Solution {
    public int minCostConnectPoints(int[][] points) {
        HashSet<Integer> set = new HashSet();
        HashMap<Integer, ArrayList<Integer>> m = new HashMap();
        int cost = 0;
        for(int i = 0; i < points.length; i++) {
            for(int j = 0; j < points.length; j++) {
                if(i != j) {
                    m.computeIfAbsent(i, k -> new ArrayList()).add(j);
                }
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        pq.add(new int[]{0, 0});
        for(; set.size() != points.length;) {
            int p[];
            for(;set.contains((p = pq.poll())[1]);){}
            set.add(p[1]);
            cost += p[0];
            for(int i : m.getOrDefault(p[1], new ArrayList<>())) {
                int[] a = points[i], b = points[p[1]];
                pq.add(new int[]{Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]), i});
            }
        }
        return cost;
    }
}