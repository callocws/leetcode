package leetcode._131;

import java.util.ArrayList;
import java.util.List;

class Solution {

    ArrayList<List<String>> r = new ArrayList();
    public List<List<String>> partition(String s) {
        traverse(s, 0, new ArrayList());
        return r;
    }
    void traverse(String s, int i, List<String> l) {
        if(i == s.length()) {
            r.add(new ArrayList(l));
            return;
        }
        for(int j = i; j < s.length(); j++) {
            String t = s.substring(i, j + 1);
            if(isPalindrome(t)) {
                l.add(t);
                traverse(s, j + 1, l);
                l.removeLast();
            }
        }
    }
    boolean isPalindrome(String s) {
        char[] cs = s.toCharArray();
        for (int i = 0; i <= s.length() / 2; i++) {
            if(cs[i] != cs[cs.length - 1 - i]) {
                return false;
            }
        }
        return cs.length != 0;
    }
}