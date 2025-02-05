package leetcode._151;

import java.util.List;

class Solution {
    public String reverseWords(String s) {
        char cs[] = new char[s.length()];
        int i = 0, j = 0, start = 0;
        for (; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (j - 1 >= 0 && cs[j - 1] != ' ') {
                    cs[j++] = s.charAt(i);
                }
            } else {
                cs[j++] = s.charAt(i);
            }
        }
        for (j--; cs[j] == ' '; j--) {}
        reverse(cs, 0, j);
        for (i = 0; i < j; i++) {
            if (cs[i] == ' ') {
                reverse(cs, start, i - 1);
                start = i + 1;
            }
        }
        reverse(cs, start, j);
        return new String(cs, 0, j + 1);
    }

    void reverse(char cs[], int i, int j) {
        for (int m = (i + j) / 2, k = 0; i + k <= m; k++) {
            char t = cs[i + k];
            cs[i + k] = cs[j - k];
            cs[j - k] = t;
        }
    }
}

class Solution1 {
    public String reverseWords(String s) {
        return String.join(" ", List.of(s.trim().split("\\s+")).reversed());
    }
}
