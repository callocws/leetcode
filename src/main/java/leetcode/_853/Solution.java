package leetcode._853;

import java.util.Arrays;


// 853. Car Fleet
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double A[][] = new double[position.length][2];
        for (int i = 0; i < position.length; i++) {
            A[i][0] = position[i];
            A[i][1] = (target - position[i]) * 1.0 / speed[i];
        }

        Arrays.sort(A, (o1, o2) -> (int) (o1[0] - o2[0]));
        int i = position.length - 1, n = 0;
        double t = A[i][1];
        for (; i >= 0; i--) {
            if (A[i][1] > t) {
                n++;
                t = A[i][1];
            }
        }
        return n;
    }

    public static void main(String[] args) {
        // [10,8,0,5,3]
        System.out.println(new Solution().carFleet(12, new int[]{10, 8, 0, 5, 3}, new int[]{2, 4, 1, 1, 3}));
    }
}