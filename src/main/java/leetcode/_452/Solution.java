package leetcode._452;

import java.util.Arrays;

class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> a[1] < b[1] ? -1 : 1);
        int cnt = 1, arrow = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (arrow < points[i][0]) {
                arrow = points[i][1];
                cnt++;
            }
        }
        return cnt;
    }
}
