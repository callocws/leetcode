package leetcode._56;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        ArrayList<int[]> arr = new ArrayList();
        int p[] = intervals[0];
        for(int i = 1; i < intervals.length; i++) {
            int[] t = intervals[i];
            if(p[1] < t[0]) {
                arr.add(p);
                p = t;
            } else {
                p = new int[]{Math.min(p[0], t[0]), Math.max(p[1], t[1])};
            }
        }
        arr.add(p);
        return arr.toArray(new int[arr.size()][]);
    }
}