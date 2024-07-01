package leetcode._435;

import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int p[] = intervals[0], cnt = 0;
        for(int i = 1; i < intervals.length; i++) {
            int t[] = intervals[i];
            if(p[1] > t[0]) {
                cnt++;
                p = t[1] < p[1] ? t : p;
            } else {
                p = t;
            }
        }
        return cnt;
    }
}