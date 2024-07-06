package leetcode._787;

import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<int[]> adj[] = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList();
        }
        for(int i = 0; i < flights.length; i++) {
            int f[] = flights[i];
            adj[f[0]].add(new int[]{f[2], f[1]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        pq.add(new int[]{0, src, -1});
        while(!pq.isEmpty()) {
            int p[] = pq.poll();
            if(p[2] > k) {
                continue;
            }
            if(p[1] == dst) {
                return p[0];
            }
            for(int[] t : adj[p[1]]) {
                pq.add(new int[]{t[0] + p[0], t[1], p[2] + 1});
            }
        }
        return -1;
    }
}