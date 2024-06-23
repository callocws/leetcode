package leetcode._295;

import java.util.PriorityQueue;

class MedianFinder {

    PriorityQueue<Integer> minpq = new PriorityQueue();
    PriorityQueue<Integer> maxpq = new PriorityQueue<>((o1, o2) -> o2 - o1);
    boolean isOdd;
    public MedianFinder() {

    }

    public void addNum(int num) {
        isOdd = !isOdd;
        if(isOdd) {
            minpq.add(num);
            maxpq.add(minpq.poll());
        } else {
            maxpq.add(num);
            minpq.add(maxpq.poll());
        }
    }

    public double findMedian() {
        if(isOdd) {
            return maxpq.peek() * 1.0;
        } else {
            return (minpq.peek() + maxpq.peek()) / 2.0;
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */