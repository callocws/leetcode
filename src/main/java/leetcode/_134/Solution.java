package leetcode._134;

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int i, j, n = gas.length, s = 0, t;
        for (i = 0; i < n; i++) {
            gas[i] -= cost[i];
        }
        for(i = 0; i < n; i++) {
            boolean found = true;
            for(j = i, s = t = 0; t < n; t++) {
                s += gas[j];
                if(s < 0) {
                    found = false;
                    break;
                }
                j = (j + 1) % n;
            }
            if(found) {
                return i;
            }
        }
        return -1;
    }
}

class Solution1 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int i, j, n = gas.length, s = 0, cnt = 0, index = 0;
        for (i = 0; i < n; i++) {
            gas[i] -= cost[i];
        }
        for(j = i = 0; i < 2 * n; i++) {
            s += gas[j];
            j = (j + 1) % n;
            if(s < 0) {
                s = 0;
                cnt = 0;
                index = j;
            } else {
                cnt++;
            }
        }
        return cnt >= n ? index : -1;
    }
}