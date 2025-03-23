package leetcode._909;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int snakesAndLadders(int[][] board) {
        List<Integer> queue = new ArrayList();
        Set<Integer> visitedSet = new HashSet();
        int cnt = 0, n = board.length, N = n * n;
        queue.add(1);

        for (int i = 0; i < queue.size(); cnt++) {
            int size = queue.size();
            for (; i < size; i++) {
                int start = queue.get(i);
                if (start == N) {
                    return cnt;
                }
                for (int j = 1; j <= 6; j++) {
                    int end = Math.min(N, start + j);
                    int row = (end - 1) / n, nrow = n - row - 1;
                    int col = (end - 1) % n;
                    if (row % 2 == 1) {
                        col = n - 1 - col;
                    }

                    if (board[nrow][col] != -1) {
                        end = board[nrow][col];
                    }

                    if (visitedSet.add(end)) {
                        queue.add(end);
                    }
                }
            }
        }
        return -1;
    }
}
