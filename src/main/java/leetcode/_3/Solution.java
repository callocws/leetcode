package leetcode._3;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> m = new HashSet();
        char[] cs = s.toCharArray();
        int ms = 0, t = 0;

        for(int i = 0, l = -1, r = -1, j; i < cs.length; i++ ) {
            char c = cs[i];
            if(m.contains(c)) {
                for(j = l + 1; cs[j] != c; j++) {
                    m.remove(cs[j]);
                }
                l = j;
            } 
            r++;
            m.add(c);
            ms = Math.max(r - l, ms);
        }
        return ms;
    }
}