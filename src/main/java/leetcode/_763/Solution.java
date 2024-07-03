package leetcode._763;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> partitionLabels(String s) {
        int A[] = new int[26], cnt = 0;
        List<Integer> result = new ArrayList();
        char cs[] = s.toCharArray();
        for(int i = 0; i < cs.length; i++) {
            int t = cs[i] - 'a';
            A[t] = Math.max(A[t], i);
        }
        for(int i = 0, r = A[cs[i] - 'a'], l = i; i < cs.length; i++) {
            r = Math.max(r, A[cs[i] - 'a']);
            if(i == r) {
                result.add(r - l + 1);
                l = r + 1;
            }
        }
        return result;
    }
}