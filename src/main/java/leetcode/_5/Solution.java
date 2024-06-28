package leetcode._5;

class Solution {
    int[] max = new int[2];
    public String longestPalindrome(String s) {
        char[] cs = s.toCharArray();
        for(int i = 0; i < cs.length; i++) {
            isP(cs, i, i);
            isP(cs, i, i + 1);
        }
        return s.substring(max[0], max[1] + 1);
    }

    int isP(char[] cs, int i, int j) {
        if(i < 0 || j < 0 || i >= cs.length || j >= cs.length || cs[i] != cs[j]) {
            return j - i - 1;
        }
        int s = isP(cs, i - 1, j + 1);
        if(max[1] - max[0] + 1 < s) {
            max = new int[]{i, j};
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("babad"));
    }
}