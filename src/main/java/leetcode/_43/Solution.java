package leetcode._43;

class Solution {

    public String multiply(String num1, String num2) {
        char num1Arr[] = num1.toCharArray(), num2Arr[] = num2.toCharArray();
        int nums[][] = new int[401][401];
        for (int i = num2Arr.length - 1; i >= 0; i--) {
            int carry = 0, k = num2Arr.length - i - 1;
            for (int j = num1Arr.length - 1; j >= 0; j--) {
                int v = (num1Arr[j] - '0') * (num2Arr[i] - '0') + carry;
                nums[k][nums.length - 1 - k - (num1Arr.length - 1 - j)] = v % 10;
                carry = v / 10;
            }
            nums[k][nums.length - 1 - k - num1Arr.length] = carry;
        }
        for (int j = nums.length - 1, carry = 0; j >= 0; j--) {
            int s = 0;
            for (int i = 0; i < nums.length; i++) {
                s += nums[i][j];
            }
            s += carry;
            nums[nums.length - 1][j] = s % 10;
            carry = s / 10;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (; i < nums.length && nums[nums.length - 1][i] == 0; i++) {}
        for (; i < nums.length; i++) {
            sb.append(nums[nums.length - 1][i] + "");
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args){
        System.out.println(new Solution().multiply("2", "3"));
    }
}
