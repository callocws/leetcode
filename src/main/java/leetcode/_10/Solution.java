package leetcode._10;

import java.util.LinkedList;
import java.util.List;

class Solution {
    Boolean dp[][] = new Boolean[21][21];

    public boolean isMatch(String s, String p) {
        LinkedList<String> list = new LinkedList();
        for (char c : p.toCharArray()) {
            String pattern = "" + c;
            if (c == '*') {
                pattern = list.removeLast() + pattern;
            }
            list.add(pattern);
        }
        return isMatch(s, list.toArray(new String[] {}), 0, 0);
    }

    boolean isMatch(String s, String[] p, int i, int j) {
        if (dp[i][j] != null) {
            return dp[i][j];
        }

        if (j == p.length && i == s.length()) {
            return true;
        }
        if (j == p.length) {
            return false;
        }
        if (i == s.length()) {
            return dp[i][j] = (p[j].length() > 1 && isMatch(s, p, i, j + 1));
        }

        if (p[j].length() > 1) {
            char c = p[j].charAt(0);
            if (isMatch(s, p, i, j + 1)) {
                return dp[i][j] = true;
            }
            if (c == '.' || c == s.charAt(i)) {
                return dp[i][j] = isMatch(s, p, i + 1, j) || isMatch(s, p, i + 1, j + 1);
            }
        } else {
            char c = p[j].charAt(0);
            if (c == '.' || c == s.charAt(i)) {
                return dp[i][j] = isMatch(s, p, i + 1, j + 1);
            }
        }
        return dp[i][j] = false;
    }

    public static void main(String[] args) {
        // "aaaaaaaaaaaaaaaaaaab"
        System.out.println(new Solution().isMatch("aaaaaaaaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*"));

        System.out.println(new Solution().isMatch("aa", "a"));
    }
}

class Solution1 {
    Boolean dp[][] = new Boolean[21][21];

    public boolean isMatch(String s, String p) {
        List<String> list = new LinkedList();
        for (char c : p.toCharArray()) {
            String pattern = "" + c;
            if (c == '*') {
                pattern = list.removeLast() + pattern;
            }
            list.add(pattern);
        }
        return isMatch(s, list, 0, 0);
    }

    boolean isMatch(String s, List<String> ps, int i, int j) {
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        if (j == ps.size() && i == s.length()) {
            return true;
        }
        if (j == ps.size()) {
            return false;
        }
        String p = ps.get(j);
        char c = p.charAt(0);
        if (i == s.length()) {
            return dp[i][j] = p.length() > 1 && isMatch(s, ps, i, j + 1);
        }
        if (p.length() == 1) {
            return dp[i][j] = (c == '.' || c == s.charAt(i)) && isMatch(s, ps, i + 1, j + 1);
        } else {
            return dp[i][j] =
                    isMatch(s, ps, i, j + 1)
                            || (c == '.' || c == s.charAt(i)) && isMatch(s, ps, i + 1, j);
        }
    }
}

class Solution2 {
    Boolean dp[][] = new Boolean[21][21];

    public boolean isMatch(String s, String p) {
        return isMatch(s.toCharArray(), p.toCharArray(), s.length() - 1, p.length() - 1);
    }

    boolean isMatch(char[] s, char[] p, int i, int j) {
        if (i < 0 && j < 0) {
            return true;
        }
        if (j < 0) {
            return false;
        }
        if (i < 0) {
            return p[j] == '*' && isMatch(s, p, i, j - 2);
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        if (p[j] == '*') {
            return dp[i][j] =
                    isMatch(s, p, i, j - 2)
                            || (p[j - 1] == '.' || p[j - 1] == s[i]) && isMatch(s, p, i - 1, j);
        } else {
            return dp[i][j] = (p[j] == '.' || p[j] == s[i]) && isMatch(s, p, i - 1, j - 1);
        }
    }
}
