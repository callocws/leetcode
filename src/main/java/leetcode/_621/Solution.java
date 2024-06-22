package leetcode._621;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> mCnt = new HashMap();
        int t = 0;
        for(char ta : tasks) {
            mCnt.put(ta, mCnt.getOrDefault(ta, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2)-> o2 - o1);
        pq.addAll(mCnt.values());
        LinkedList<int[]> l = new LinkedList();

        for(;!pq.isEmpty() || !l.isEmpty(); t++) {
            if(!l.isEmpty() && l.peek()[1] <= t) {
                pq.add(l.poll()[0]);
            }
            Integer k = pq.poll();
            if(k == null) {
                continue;
            }
            if(k > 1) {
                l.add(new int[]{k - 1, t + n + 1});
            }
        }
        return t;
    }
}