package leetcode._567;

import java.util.HashMap;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> h = new HashMap();
        for(char c: s1.toCharArray()) {
            h.put(c, h.getOrDefault(c, 0) + 1);
        }
        char[] cs = s2.toCharArray();
        for(int i = 0; i < cs.length; i++) {
            h.put(cs[i], h.getOrDefault(cs[i], 0) - 1);

            if(i >= s1.length()) {
                h.put(cs[i - s1.length()], h.getOrDefault(cs[i - s1.length()], 0) + 1);
            }

            boolean b = true;
            for(int v : h.values()) {
                if(v != 0) {
                    b = false;
                    break;
                }
            }
            if(b) {
                return true;
            }
        }

        return false;
    }
}