package leetcode._84;

import java.util.Stack;

// 84. Largest Rectangle in Histogram
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = 0;
        for(int i = 0; i < heights.length; i++) {
            for(int j = i, t = heights[j]; j < heights.length; j++) {
                t = Math.min(t, heights[j]);
                n = Math.max(n, (j - i + 1) * t);
            }
        }
        return n;
    }
}

class Solution1 {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> s = new Stack();
        int m = 0;
        for(int i = 0; i < heights.length; i++) {
            int[] p = new int[]{i, heights[i]};
            for(;!s.isEmpty() && s.peek()[1] >= heights[i];) {
                int[] t = s.pop();
                m = Math.max(m, t[1] * (i - t[0]));
                p[0] = t[0];
            }
            s.push(p);
        }
        for(;!s.isEmpty();) {
            int[] t = s.pop();
            m = Math.max(m, t[1] * (heights.length - t[0]));
        }
        return m;
    }
}