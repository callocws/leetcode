package leetcode._1062;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int longestRepeatingSubstring(String s) {
        int cnt = 0;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (!set.add(s.substring(i, j))) {
                    cnt = Math.max(cnt, j - i);
                }
            }
        }
        return cnt;
    }
}

class Solution1 {
    Integer dp[][] = new Integer[1000][1000];

    public int longestRepeatingSubstring(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                cnt = Math.max(cnt, longestRepeatingSubstring(i, j, s));
            }
        }
        return cnt;
    }

    int longestRepeatingSubstring(int i, int j, String s) {
        if (i >= 0 && s.charAt(i) == s.charAt(j)) {
            if (dp[i][j] != null) {
                return dp[i][j];
            }
            return dp[i][j] = longestRepeatingSubstring(i - 1, j - 1, s) + 1;
        }
        return 0;
    }
}
