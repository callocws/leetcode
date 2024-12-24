package leetcode._678;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public boolean checkValidString(String s) {
        char cs[] = s.toCharArray();
        return f(cs, 0, 0);
    }

    boolean f(char cs[], int i, int n) {
        if (n < 0) {
            return false;
        }
        if (i == cs.length) {
            return n == 0;
        }
        if (cs[i] == '(') {
            return f(cs, i + 1, n + 1);
        } else if (cs[i] == ')') {
            return f(cs, i + 1, n - 1);
        }
        return f(cs, i + 1, n) || f(cs, i + 1, n - 1) || f(cs, i + 1, n + 1);
    }
}

class Solution1 {
    public boolean checkValidString(String s) {
        char cs[] = s.toCharArray();
        boolean dp[][] = new boolean[cs.length + 1][cs.length + 1];
        dp[0][0] = true;
        for (int i = 0; i < dp.length - 1; i++) {
            for (int j = 0; j < dp.length; j++) {
                if (dp[i][j]) {
                    if (cs[i] == '(') {
                        dp[i + 1][j + 1] = true;
                    } else if (cs[i] == ')' && j - 1 >= 0) {
                        dp[i + 1][j - 1] = true;
                    } else if (cs[i] == '*') {
                        dp[i + 1][j] = true;
                        if (j - 1 >= 0) {
                            dp[i + 1][j - 1] = true;
                        }
                        dp[i + 1][j + 1] = true;
                    }
                }
            }
        }
        return dp[cs.length][0];
    }
}

class Solution2 {
    public boolean checkValidString(String s) {
        int min = 0, max = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                min++;
                max++;
            } else if (c == ')') {
                min--;
                max--;
            } else {
                min--;
                max++;
            }
            if (max < 0) {
                return false;
            }
            min = Math.max(0, min);
        }
        return min == 0;
    }
}

class Solution_wrong {
    public boolean checkValidString(String s) {
        List<Integer> l = new LinkedList(), r = new LinkedList(), star = new LinkedList();
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '(') {
                l.add(i);
            } else if (cs[i] == ')') {
                r.add(i);
            } else {
                star.add(i);
            }
        }
        for (; !l.isEmpty() && !r.isEmpty() && l.getFirst() < r.getLast(); ) {
            l.removeFirst();
            r.removeLast();
        }
        for (; !l.isEmpty() && !star.isEmpty() && l.getFirst() < star.getLast(); ) {
            l.removeFirst();
            star.removeLast();
        }
        for (; !r.isEmpty() && !star.isEmpty() && star.getFirst() < r.getLast(); ) {
            star.removeFirst();
            r.removeLast();
        }
        return l.isEmpty() && r.isEmpty();
    }
}
