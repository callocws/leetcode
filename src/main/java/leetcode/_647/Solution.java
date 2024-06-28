package leetcode._647;

class Solution {
    int cnt = 0;
    public int countSubstrings(String s) {
        char[] cs = s.toCharArray();
        for(int i = 0; i < cs.length; i++) {
            isP(cs, i, i);
            isP(cs, i, i + 1);
        }
        return cnt;
    }

    void isP(char[] cs, int i, int j) {
        if(i < 0 || j >= cs.length || cs[i] != cs[j]) {
            return;
        }
        cnt++;
        isP(cs, i - 1, j + 1);
    }
}


