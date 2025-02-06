package leetcode._274;

import java.util.Arrays;

class Solution {
    public int hIndex(int[] citations) {
        int i = 0, j = Math.min(1000, citations.length);
        for (; i <= j; ) {
            int m = (i + j) / 2, cnt = 0;
            for (int k = 0; k < citations.length; k++) {
                if (citations[k] >= m) {
                    cnt++;
                }
            }
            if (cnt == m) {
                i = m + 1;
            } else if (cnt > m) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return i - 1;
    }
}

class Solution1 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int i = citations.length - 1, cnt = 0;
        for (; i >= 0; i--, cnt++) {
            if (citations[i] < cnt + 1) {
                break;
            }
        }
        return cnt;
    }
}
