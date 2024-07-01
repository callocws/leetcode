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

class Solution1 {
    public int minMeetingRooms(List<Interval> intervals) {
        int start[] = new int[intervals.size()], end[] = new int[intervals.size()];
        intervals.sort((o1, o2) -> o1.start - o2.start);
        for(int i = 0; i < intervals.size(); i++) {
            start[i] = intervals.get(i).start;
        }
        intervals.sort((o1, o2) -> o1.end - o2.end);
        for(int i = 0; i < intervals.size(); i++) {
            end[i] = intervals.get(i).end;
        }
        int i, j, cnt = 0, m = 0;
        for(i = j = 0; i < start.length && j < start.length;) {
            if(start[i] < end[j]) {
                cnt++;
                m = Math.max(m, cnt);
                i++;
            } else {
                cnt--;
                j++;
            }
        }
        return m;
    }
}