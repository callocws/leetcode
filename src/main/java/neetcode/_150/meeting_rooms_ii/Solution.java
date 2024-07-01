package neetcode._150.meeting_rooms_ii;

import java.util.List;
import java.util.PriorityQueue;

class Interval {
    int start, end;
    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort((o1, o2) -> o1.start - o2.start);
        PriorityQueue<Integer> pq = new PriorityQueue();
        pq.add(intervals.get(0).end);
        for(int i = 1; i < intervals.size(); i++) {
            Interval t = intervals.get(i);
            if(pq.peek() <= t.start) {
                pq.poll();
            }
            pq.add(t.end);
        }
        return pq.size();
    }
}