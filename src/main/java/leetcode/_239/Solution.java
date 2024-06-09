package leetcode._239;

import java.util.LinkedList;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int A[] = new int[nums.length - k + 1];
        LinkedList<Integer> l = new LinkedList();
        for(int i = 0; i < nums.length; i++) {
            for(;!l.isEmpty() && nums[l.getLast()] < nums[i];) {
                l.removeLast();
            }
            l.add(i);

            if(i - k >= l.peek()) {
                l.pop();
            }

            int t = i - k + 1;
            if(t >= 0) {
                A[t] = nums[l.peek()];
            } 
        }
        return A;
    }
}