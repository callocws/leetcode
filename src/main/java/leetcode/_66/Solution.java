package leetcode._66;

class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for(int i = digits.length - 1; i >= 0 ; i--) {
            digits[i] += carry;
            carry = digits[i] / 10;
            digits[i] %= 10;
        }
        if(carry == 1) {
            int[] digits1 = new int[digits.length + 1];
            digits1[0] = 1;
            return digits1;
        }
        return digits;
    }
}