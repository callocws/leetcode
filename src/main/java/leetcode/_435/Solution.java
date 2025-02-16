package leetcode._435;

import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int lastInterval[] = intervals[0], cnt = 0;
        for (int i = 1; i < intervals.length; i++) {
            int nextInterval[] = intervals[i];
            if (lastInterval[1] > nextInterval[0]) {
                cnt++;
                lastInterval = nextInterval[1] < lastInterval[1] ? nextInterval : lastInterval;
            } else {
                lastInterval = nextInterval;
            }
        }
        return cnt;
    }
}
