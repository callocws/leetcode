package leetcode._190;

public class Solution {
    public int reverseBits(int n) {
        for(int i = 0; i < 15; i++) {
            int h = (n >>> (31 - i)) & 1, l = (n >>> i) & 1;
            n &= ~(1 << i) & ~(1 << (31 - i));
            n |= (h << i) | (l << (31 - i));
        }
        return n;
    }
}