package leetcode._567;

import java.util.HashMap;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> h = new HashMap();
        for (char c : s1.toCharArray()) {
            h.put(c, h.getOrDefault(c, 0) + 1);
        }
        char[] cs = s2.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            h.put(cs[i], h.getOrDefault(cs[i], 0) - 1);

            if (i >= s1.length()) {
                h.put(cs[i - s1.length()], h.getOrDefault(cs[i - s1.length()], 0) + 1);
            }

            if (isValid(h)) {
                return true;
            }
        }

        return false;
    }

    boolean isValid(HashMap<Character, Integer> h) {
        for (int v : h.values()) {
            if (v != 0) {
                return false;
            }
        }
        return true;
    }
}

class Solution1 {
    public boolean checkInclusion(String s1, String s2) {
        char cs1[] = s1.toCharArray(), cs2[] = s2.toCharArray();
        int count[] = new int[26], l, r;
        for (char c : cs1) {
            count[c - 'a']++;
        }
        for (l = r = 0; r < cs2.length; r++) {
            int c = cs2[r] - 'a';
            if (count[c] == 0) {
                for (; cs2[l++] != cs2[r]; ) {
                    count[cs2[l - 1] - 'a']++;
                }
            } else {
                count[c]--;
            }
            if (r - l + 1 == cs1.length) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().checkInclusion("pqzhi", "ghrqpihzybre"));

        System.out.println(new Solution1().checkInclusion("ab", "eidboaoo"));
    }
}
