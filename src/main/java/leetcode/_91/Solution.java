package leetcode._91;

class Solution {
    public int numDecodings(String s) {
        int a, b, i;
        char[] cs = s.toCharArray();
        for(a = b = i = 0; i < cs.length; i++) {
            int t = 0;
            if(i > 0 && ('1' == cs[i - 1] || cs[i - 1] == '2' && '0' <= cs[i] && cs[i] <= '6')) {
                t += a;
                if(i == 1) {
                    t += 1;
                }
            }
            if('1' <= cs[i] && cs[i] <= '9') {
                t += b;
                if(i == 0) {
                    t += 1;
                }
            }
            a = b;
            b = t;
        }
        return b;
    }
}