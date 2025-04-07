package leetcode._201;

class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int sum = 0;
        for (int i = 30; i >= 0; i--) {
            int t = 1 << i;
            if ((t & left) == (t & right)) {
                sum += t & left;
            } else {
                break;
            }
        }
        return sum;
    }
}
