package leetcode._125;

// 125. Valid Palindrome
class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()) {
            if(('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z') || ('0' <= c && c <= '9')) {
                sb.append(c);
            }
        }
        char[] cs = sb.toString().toLowerCase().toCharArray();
        for(int i = 0; i < cs.length / 2; i++) {
            if(cs[i] != cs[cs.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}