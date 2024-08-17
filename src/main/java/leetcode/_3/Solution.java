package leetcode._3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> m = new HashSet();
        char[] cs = s.toCharArray();
        int ms = 0;

        for (int i = 0, l = -1, r = -1, j; i < cs.length; i++) {
            char c = cs[i];
            if (m.contains(c)) {
                for (j = l + 1; cs[j] != c; j++) {
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

class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> m = new HashMap();
        char cs[] = s.toCharArray();
        int result = 0;
        for (int i = 0, j = 0, k = 0; i < cs.length; i++) {
            Integer index = m.get(cs[i]);
            if (index == null) {
                k++;
                result = Math.max(result, k);
                m.put(cs[i], i);
            } else {
                for (; j <= index; j++) {
                    m.put(cs[j], null);
                    k--;
                }
                i--;
            }
        }
        return result;
    }
}

class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> m = new HashMap();
        char cs[] = s.toCharArray();
        int result = 0;
        for (int i = 0, j = 0; i < cs.length; i++) {
            Integer index = m.get(cs[i]);
            if (index != null) {
                j = Math.max(j, index + 1);
            }
            m.put(cs[i], i);
            result = Math.max(result, i - j + 1);
        }
        return result;
    }
}
