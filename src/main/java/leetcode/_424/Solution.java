package leetcode._424;

class Solution {
    public int characterReplacement(String s, int k) {
        char[] cs = s.toCharArray();
        int A[] = new int[26], i, l, r, m = 0;
        for(i = 0, l = r = -1; i < cs.length; i++) {
            A[cs[++r] - 'A']++;

            for(;r - l - max(A) > k;) {
                A[cs[++l] - 'A']--;
            }
            m = Math.max(m, r - l);
        }
        return m;
    }

    int max(int[] A) {
        int t = 0;
        for(int i = 1; i < 26; i++) {
            if(A[i] > A[t]) {
                t = i;
            }
        }
        return A[t];
    }
}