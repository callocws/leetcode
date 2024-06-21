package leetcode._1046;

import java.util.PriorityQueue;

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for(int s : stones) {
            pq.add(s);
        }
        for(;pq.size() >= 2;) {
            int x = pq.poll(), y = pq.poll(), t = Math.abs(x - y);
            if(t > 0) {
                pq.add(t);
            }
        }
        return pq.size() == 0 ? 0 : pq.peek();
    }
}