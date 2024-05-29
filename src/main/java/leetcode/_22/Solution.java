package leetcode._22;

import java.util.LinkedList;
import java.util.List;

// 22. Generate Parentheses
class Solution {
    LinkedList<String> ll = new LinkedList();
    public List<String> generateParenthesis(int n) {
        f("", n, n, 0);
        return ll;
    }

    void f(String s, int l, int r, int n) {
        if(n < 0) {
            return;
        }
        if(l == 0 && r == 0) {
            ll.add(s);
        }
        if(l > 0) {
            f(s + "(", l - 1, r, n + 1);
        }
        if(r > 0) {
            f(s + ")", l, r - 1, n - 1);
        }
    }
}