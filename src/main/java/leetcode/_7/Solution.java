package leetcode._7;

class Solution {
    public int reverse(int x) {
        int sign = x >= 0 ? 1 : -1, result = 0;;
        for(x = Math.abs(x); x != 0; x /= 10) {
            if((Integer.MAX_VALUE - x % 10) / 10 < result) {
                return 0;
            }
            result = 10 * result + x % 10;
        }
        return sign * result;
    }
}