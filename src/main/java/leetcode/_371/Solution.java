package leetcode._371;

class Solution {
    public int getSum(int a, int b) {
        for(; a != 0;) {
            int c = a ^ b;
            a = (a & b) << 1;
            b = c;
        }
        return b;
    }
}