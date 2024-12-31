package leetcode._125;

// 125. Valid Palindrome
class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z') || ('0' <= c && c <= '9')) {
                sb.append(c);
            }
        }
        char[] cs = sb.toString().toLowerCase().toCharArray();
        for (int i = 0; i < cs.length / 2; i++) {
            if (cs[i] != cs[cs.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}

class Solution1 {
    public boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; ) {
            char a = s.charAt(i), b = s.charAt(j);
            if (!isValid(a)) {
                i++;
            } else if (!isValid(b)) {
                j--;
            } else if (Character.toLowerCase(a) != Character.toLowerCase(b)) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    boolean isValid(char c) {
        return ('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z') || ('0' <= c && c <= '9');
    }
}
