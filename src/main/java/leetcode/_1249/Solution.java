package leetcode._1249;

import java.util.LinkedList;

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


class Solution1 {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        LinkedList<Integer> l = new LinkedList();
        char cs[] = s.toCharArray();
        for(int i = 0; i < cs.length; i++) {
            if(cs[i] == '(') {
                l.push(i);
            }
            if(cs[i] == ')') {
                if(l.isEmpty()) {
                    cs[i] = '.';
                } else {
                    l.pop();
                }
            }
        }
        for(int index : l) {
            cs[index] = '.';
        }
        for(char c : cs) {
            if(c != '.') {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}