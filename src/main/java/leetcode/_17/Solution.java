package leetcode._17;

import java.util.ArrayList;
import java.util.List;

class Solution {
    ArrayList<String> r = new ArrayList();
    String[] A = new String[]{null, null, "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public List<String> letterCombinations(String digits) {
        traverse(digits, 0, "");
        return "".equals(digits) ? List.of() : r;
    }
    void traverse(String digits, int i, String s) {
        if(i == digits.length()) {
            r.add(s);
            return;
        }
        String p = A[digits.charAt(i) - '0'];
        for(int j = 0; j < p.length(); j++) {
            traverse(digits, i + 1, s + p.charAt(j));
        }
    }
}
