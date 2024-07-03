package leetcode._846;

import java.util.TreeMap;

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer, Integer> m = new TreeMap();
        for(int k : hand) {
            m.put(k, m.getOrDefault(k, 0) + 1);
        }
        for(int k : m.keySet()) {
            int s = m.get(k);
            if(s == 0) {
                continue;
            }
            for(int i = 1; i < groupSize; i++) {
                int t = m.getOrDefault(k + i, 0);
                if(t - s < 0) {
                    return false;
                }
                m.put(k + i, t - s);
            }
        }
        return true;
    }
}