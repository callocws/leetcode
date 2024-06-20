package leetcode._51;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    ArrayList<List<String>> r = new ArrayList();
    public List<List<String>> solveNQueens(int n) {
        char[][] A = new char[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(A[i], '.');
        }
        for(int t = 0; t < A.length; t++) {
            traverse(A, 0, t);
        }
        return r;
    }

    void traverse(char[][] A, int i, int j) {
        if(i == A.length || i < 0 || j == A.length || j < 0 || A[i][j] == 'Q' || !isOk(A, i, j)) {
            return;
        }
        A[i][j] = 'Q';
        if(i == A.length - 1) {
            ArrayList<String> l = new ArrayList();
            for(int t = 0; t < A.length; t++) {
                l.add(new String(A[t]));
            }
            r.add(l);
            A[i][j] = '.';
            return;
        }

        for(int t = 0; t < A.length; t++) {
            traverse(A, i + 1, t);
        }
        A[i][j] = '.';
    }

    boolean isOk(char[][] A, int x, int y) {
        for(int i = 1; i < A.length; i++) {
            if(x - i >= 0) {
                if(A[x - i][y] == 'Q' || y - i >= 0 && A[x - i][y - i] == 'Q' || y + i < A.length && A[x - i][y + i] == 'Q') {
                    return false;
                }
            }
        }
        return true;
    }
}