package leetcode._528;

import java.util.Random;

class Solution {
    int size;
    Random r;
    int[] w;

    public Solution(int[] w) {
        size = w.length;
        for (int i = 1; i < size; i++) {
            w[i] += w[i - 1];
        }
        r = new Random();
        this.w = w;
    }

    public int pickIndex() {
        int v = r.nextInt(w[size - 1]);
        for (int i = 0; i < size; i++) {
            if (v < w[i]) {
                return i;
            }
        }
        return size - 1;
    }
}

class Solution1 {
    int size;
    Random r;
    int[] w;

    public Solution1(int[] w) {
        size = w.length;
        for (int i = 1; i < size; i++) {
            w[i] += w[i - 1];
        }
        r = new Random();
        this.w = w;
    }

    public int pickIndex() {
        int v = r.nextInt(w[size - 1]);
        int m, i, j;
        for (i = 0, j = size - 1; i < j; ) {
            m = (i + j) >> 1;
            if (v < w[m]) {
                j = m;
            } else {
                i = m + 1;
            }
        }
        return i;
    }
}

class Solution2 {
    int size;
    Random r;
    int[] w;

    public Solution2(int[] w) {
        size = w.length;
        for (int i = 1; i < size; i++) {
            w[i] += w[i - 1];
        }
        r = new Random();
        this.w = w;
    }

    public int pickIndex() {
        int v = r.nextInt(w[size - 1]);
        int m, i, j;
        for (i = 0, j = size - 1; i <= j; ) {
            m = (i + j) >> 1;
            if (v < w[m]) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return i;
    }
}
