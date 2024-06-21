package leetcode._973;

import static java.lang.Math.*;

import java.util.PriorityQueue;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((A, B) -> (int) (-(pow(A[0], 2) + pow(A[1], 2)) + pow(B[0], 2) + pow(B[1], 2)));
        for(int[] p : points) {
            pq.add(p);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        int n = pq.size();
        int[][] ps = new int[n][0];
        for(int i = 0; i < n; i++) {
            ps[i] = pq.poll();
        }
        return ps;
    }
}