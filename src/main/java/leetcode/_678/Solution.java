package leetcode._678;

class Solution {
    public boolean checkValidString(String s) {
        char cs[] = s.toCharArray();
        return f(cs, 0, 0);
    }

    boolean f(char cs[], int i, int n) {
        if(n < 0) {
            return false;
        }
        if(i == cs.length) {
            return n == 0;
        }
        if(cs[i] == '(') {
            return f(cs, i + 1, n + 1);
        } else if(cs[i] == ')') {
            return f(cs, i + 1, n - 1);
        }
        return  f(cs, i + 1, n) || f(cs, i + 1, n - 1) || f(cs, i + 1, n + 1);
    }
}