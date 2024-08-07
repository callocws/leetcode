package leetcode._202;

import java.util.HashSet;

class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet();
        for(; n != 1 && !set.contains(n);) {
            set.add(n);
            int t = 0;
            for(; n != 0; n /= 10) {
                t += (int)Math.pow(n % 10, 2);
            }
            n = t;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isHappy(19));
        System.out.println(new Solution().isHappy(2));
    }
}