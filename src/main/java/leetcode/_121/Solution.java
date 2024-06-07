package leetcode._121;

import java.util.LinkedList;

class Solution {
    public int maxProfit(int[] prices) {
        LinkedList<Integer> l = new LinkedList();
        int m = 0;
        for(int i = 0; i < prices.length; i++) {
        	if(l.isEmpty()) {
        		l.add(prices[i]);
        	} else if(l.getLast() < prices[i]) {
        		if(l.size() == 2) {
        			l.removeLast();
        		}
        		l.add(prices[i]);
        		m = Math.max(l.get(1) - l.get(0), m);
        	} else if(l.peek() > prices[i]) {
        		l.clear();
        		l.add(prices[i]);
        	}
        }
        return m;
    }
}

class Solution1 {
	public int maxProfit(int[] prices) {
		int m = 0, l = prices[0];
		for(int i = 1; i < prices.length; i++) {
			m = Math.max(m, prices[i] - l);
			l = Math.min(l, prices[i]);
		}
		return m;
	}
}