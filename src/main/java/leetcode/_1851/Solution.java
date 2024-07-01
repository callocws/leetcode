package leetcode._1851;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int qs[] = queries.clone(), i, j;
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        Arrays.sort(qs);
        HashMap<Integer, Integer> m = new HashMap();
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((o1, o2)-> o1[0] - o2[0]);
        for(i = j = 0;j < qs.length; j++) {
            for(;i < intervals.length && intervals[i][0] <= qs[j]; i++) {
                if(intervals[i][1] >= qs[j]) {
                    pq.add(new int[]{intervals[i][1] - intervals[i][0] + 1, intervals[i][1]});
                }
            }
            for(;!pq.isEmpty() && pq.peek()[1] < qs[j];) {
                pq.poll();
            }
            if(!pq.isEmpty()) {
                m.put(qs[j], pq.peek()[0]);
            }
        }
        for(i = 0; i < qs.length; i++) {
            qs[i] = m.getOrDefault(queries[i], -1);
        }
        return qs;
    }

    public static void main(String[] args) {
        // intervals =
        //[[4,5],[5,8],[1,9],[8,10],[1,6]]
        //queries =
        //[7,9,3,9,3]
        int[][] intervals = {{4,5},{5,8},{1,9},{8,10},{1,6}};
        int[] queries = {7,9,3,9,3};
        System.out.println(Arrays.toString(new Solution().minInterval(intervals, queries)));
    }
}