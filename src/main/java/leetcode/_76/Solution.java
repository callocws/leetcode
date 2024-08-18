package leetcode._76;

import java.util.HashMap;

class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> h = new HashMap();
        String m = s;
        boolean b = false;
        for (char c : t.toCharArray()) {
            h.put(c, h.getOrDefault(c, 0) + 1);
        }

        char[] cs = s.toCharArray();
        for (int l = 0, r = 0; r < cs.length; r++) {
            Integer k = h.get(cs[r]);
            if (k != null) {
                h.put(cs[r], k - 1);
            }
            for (; isValid(h); l++) {
                b = true;
                m = m.length() < r - l + 1 ? m : s.substring(l, r + 1);

                k = h.get(cs[l]);
                if (k != null) {
                    h.put(cs[l], k + 1);
                }
            }
        }

        return b ? m : "";
    }

    boolean isValid(HashMap<Character, Integer> h) {
        for (int k : h.values()) {
            if (k > 0) {
                return false;
            }
        }
        return true;
    }
}

class Solution1 {
    public String minWindow(String s, String t) {
        int cnt[] = new int[128];
        for (char c : t.toCharArray()) {
            cnt[c]++;
        }
        int l, r;
        String m = "";
        char cs[] = s.toCharArray();
        for (l = r = 0; r < cs.length; r++) {
            cnt[cs[r]]--;
            for (; isValid(cnt); l++) {
                if (m == "" || m.length() > r - l + 1) {
                    m = s.substring(l, r + 1);
                }
                cnt[cs[l]]++;
            }
        }
        return m;
    }

    boolean isValid(int cnts[]) {
        for (int cnt : cnts) {
            if (cnt > 0) {
                return false;
            }
        }
        return true;
    }
}

class Solution2 {
    public String minWindow(String s, String t) {
        char cs[] = s.toCharArray(), ct[] = t.toCharArray();
        int count[] = new int[128], result[] = new int[] {0, 1_000_000};
        for (char c : ct) {
            count[c]++;
        }
        for (int l = 0, r = 0; r < cs.length; r++) {
            count[cs[r]]--;
            for (; check(count); ) {
                if (r - l < result[1] - result[0]) {
                    result = new int[] {l, r};
                }
                count[cs[l++]]++;
            }
        }
        return result[1] - result[0] == 1000_000 ? "" : s.substring(result[0], result[1] + 1);
    }

    boolean check(int count[]) {
        for (int cnt : count) {
            if (cnt > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().minWindow("ADOBECODEBANC", "ABC"));
    }
}

class Solution3 {
    public String minWindow(String s, String t) {
        char cs[] = s.toCharArray(), ct[] = t.toCharArray();
        int count[] = new int[128], result[] = new int[] { 0, 1_000_000 };
        for (char c : ct) {
            count[c]++;
        }
        for (int l = 0, r = 0, k = ct.length; r < cs.length; r++) {
            if(count[cs[r]]-- > 0) {
                k--;
            }

            for (; k == 0;) {
                if (r - l < result[1] - result[0]) {
                    result = new int[] { l, r };
                }
                if(count[cs[l++]]++ == 0) {
                    k++;
                }
            }
        }
        return result[1] - result[0] == 1000_000 ? "" : s.substring(result[0], result[1] + 1);
    }
}