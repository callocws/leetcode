package leetcode._703;

import java.util.PriorityQueue;

class KthLargest {

    PriorityQueue<Integer> p = new PriorityQueue();
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int num : nums) {
            p.add(num);
            if(p.size() > k) {
                p.poll();
            }
        }
    }

    public int add(int val) {
        p.add(val);
        if(p.size() > k) {
            p.poll();
        }
        return p.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */