package leetcode._1249;

class Solution {
    public String minRemoveToMakeValid(String s) {
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            if(c == '(') {
                cnt++;
            } 
            if(c == ')') {
             if(cnt == 0) {
                continue;
             } else {
                cnt--;
             }
            } 
            sb.append(c);
        }
        char cs[] = sb.toString().toCharArray();
        s = "";
        for(int i = cs.length - 1; i >= 0; i--) {
            if(cnt > 0 && cs[i] == '(') {
                cnt--;
                continue;
            }
            s = cs[i] + s;
        }
        return s;
    }
}