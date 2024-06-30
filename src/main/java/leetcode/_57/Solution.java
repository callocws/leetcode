package leetcode._57;

import java.util.ArrayList;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0) {
            return new int[][]{newInterval};
        }
        ArrayList<int[]> arr1 = new ArrayList(), arr2 = new ArrayList();
        boolean first = true;
        for(int[] inter : intervals) {
            if(first && inter[0] >= newInterval[0]) {
                arr1.add(newInterval);
                first = false;
            }
            arr1.add(inter);
        }
        if(first) {
            arr1.add(newInterval);
        }
        arr2.add(arr1.removeFirst());
        for(int[] t : arr1) {
            int[] p = arr2.getLast();
            if(p[1] >= t[0]) {
                arr2.removeLast();
                arr2.add(new int[]{Math.min(p[0], t[0]), Math.max(p[1], t[1])});
            } else {
                arr2.add(t);
            }
        }
        int[][] r = new int[arr2.size()][2];
        for(int i = 0; i < r.length; i++) {
            r[i] = arr2.get(i);
        }
        return r;
    }
}

class Solution1 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> arr = new ArrayList();
        boolean first = true;
        for(int[] inter : intervals) {
            if(newInterval[1] < inter[0]) {
                if(first) {
                    arr.add(newInterval);
                    first = false;
                }
                arr.add(inter);
            } else if(newInterval[0] > inter[1]) {
                arr.add(inter);
            } else {
                newInterval = new int[]{Math.min(newInterval[0], inter[0]), Math.max(newInterval[1], inter[1])};
            }
        }
        if(first) {
            arr.add(newInterval);
        }
        return arr.toArray(new int[arr.size()][]);
    }
}