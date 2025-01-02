package leetcode._739;

import java.util.Stack;

// 739. Daily Temperatures
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s = new Stack();
        int[] A = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            for (; !s.isEmpty() && temperatures[i] > temperatures[s.peek()]; ) {
                int j = s.pop();
                A[j] = i - j;
            }
            s.push(i);
        }
        return A;
    }
}
