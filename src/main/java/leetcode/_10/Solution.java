package leetcode._10;

import java.util.LinkedList;

class Solution {
    Boolean dp[][] = new Boolean[21][21];
    public boolean isMatch(String s, String p) {
        LinkedList<String> l = new LinkedList();
        for(char c : p.toCharArray()) {
            String ns = "" + c;
            if(c == '*') {
                ns = l.removeLast() + ns;
            }
            l.add(ns);
        }
        return isMatch(l.toArray(new String[]{}), s, 0, 0);
    }

    boolean isMatch(String p[], String s, int i, int j) {
        if(dp[i][j] != null) {
            return dp[i][j];
        }

        if(i == p.length && j == s.length()) {
            return true;
        }
        if(i == p.length) {
            return false;
        }
        if(j == s.length()) {
            return dp[i][j] =(p[i].length() > 1 && isMatch(p, s, i + 1, j));
        }

        if(p[i].length() > 1) {
            char c = p[i].charAt(0);
            if(isMatch(p, s, i + 1, j)) {
                return dp[i][j] = true;
            }
            if(c == '.' || c == s.charAt(j)) {
                return dp[i][j] = isMatch(p, s, i, j + 1) || isMatch(p, s, i + 1, j + 1);
            }
        } else {
            char c = p[i].charAt(0);
            if(c == '.' || c == s.charAt(j)) {
                return dp[i][j] = isMatch(p, s, i + 1, j + 1);
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