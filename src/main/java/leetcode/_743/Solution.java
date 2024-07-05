package leetcode._743;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<int[]> adj[] = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            adj[i] = new ArrayList();
        }
        for(int[] t : times) {
            adj[t[0]].add(new int[]{t[1], t[2]});
        }
        HashSet<Integer> set = new HashSet();
        int cost = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        pq.add(new int[]{0, k});
        while(set.size() < n && !pq.isEmpty()) {
            int p[] = pq.poll();
            set.add(p[1]);
            cost = p[0];
            for(int[] t : adj[p[1]]) {
                if(!set.contains(t[0])) {
                    pq.add(new int[]{t[1] + p[0], t[0]});
                }
            }
        }
        return set.size() == n ? cost : -1;
    }
}