package leetcode._921;

class Solution {
    public int minAddToMakeValid(String s) {
        int cnt = 0, result = 0;
        for(char c : s.toCharArray()) {
            if(c == '(') {
                cnt++;
            }
            if(c == ')') {
                if(cnt == 0) {
                    result++; 
                } else {
                    cnt--;
                }
            }
        }
        return cnt + result;
    }
}