package leetcode._417;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {

    LinkedList<List<Integer>> r = new LinkedList();
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int[][] B = new int[heights.length][heights[0].length];
        for(int i = 0; i < heights.length; i++) {
            Arrays.fill(B[i], 0);
        }
        for(int i = 0; i < heights.length; i++) {
            traverse(heights, B, i, 0, 2);
            traverse(heights, B, i, heights[0].length - 1, 1);
        }
        for(int i = 0; i < heights[0].length; i++) {
            traverse(heights, B, 0, i, 2);
            traverse(heights, B, heights.length - 1, i, 1);
        }

        for(int i = 0; i < heights.length; i++) {
            for(int j = 0; j < heights[i].length; j++) {
                if(B[i][j] == 3) {
                    LinkedList<Integer> l = new LinkedList();
                    l.add(i);
                    l.add(j);
                    r.add(l);
                }
            }
        }
        return r;
    }

    void traverse(int[][] A, int[][] B, int i, int j, int t) {
        if(i < 0 || i >= A.length || j < 0 || j >= A[0].length || (t & B[i][j]) > 0) {
            return;
        }
        B[i][j] |= t;
        if(i - 1 >= 0 && A[i][j] <= A[i - 1][j]) {
            traverse(A, B, i - 1, j, t);
        }
        if(i + 1 < A.length && A[i][j] <= A[i + 1][j]) {
            traverse(A, B, i + 1, j, t);
        }
        if(j - 1 >= 0 && A[i][j] <= A[i][j - 1]) {
            traverse(A, B, i, j - 1, t);
        }
        if(j + 1 < A[0].length && A[i][j] <= A[i][j + 1]) {
            traverse(A, B, i, j + 1, t);
        }
    }
}