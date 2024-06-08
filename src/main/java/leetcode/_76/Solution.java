package leetcode._76;

import java.util.HashMap;

class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> h = new HashMap();
        String m = s;
        boolean b = false;
        for(char c : t.toCharArray()) {
            h.put(c, h.getOrDefault(c, 0) + 1);
        }

        char[] cs = s.toCharArray();
        for(int l = 0, r = 0; r < cs.length; r++) {
            Integer k = h.get(cs[r]);
            if(k != null) {
                h.put(cs[r], k - 1);
            }
            for(;isValid(h); l++) {
                b = true;
                m = m.length() < r - l + 1 ? m : s.substring(l, r + 1);

                k = h.get(cs[l]);
                if(k != null) {
                    h.put(cs[l], k + 1);
                }
            }

        }

        return b ? m : "";
    }

    boolean isValid(HashMap<Character, Integer> h) {
        for(int k : h.values()) {
            if(k > 0) {
                return false;
            }
        }
        return true;
    }
}