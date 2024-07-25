package leetcode._190;

public class Solution {
    public int reverseBits(int n) {
        for(int i = 0; i <= 15; i++) {
            int h = (n >>> (31 - i)) & 1, l = (n >>> i) & 1;
            n &= ~(1 << i) & ~(1 << (31 - i));
            n |= (h << i) | (l << (31 - i));
        }
        return n;
    }
}

class Solution1 {
    public int reverseBits(int n) {
        int res = 0;
        for(int i = 0; i < 32; i++) {
            res <<= 1;
            res |= n & 1;
            n >>= 1;
        }
        return res;
    }
}