package leetcode._1899;

class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean r[] = new boolean[3];
        for(int i = 0; i < triplets.length; i++) {
            boolean valid = true;
            for(int j = 0; j < 3; j++) {
                if(triplets[i][j] > target[j]) {
                    valid = false;
                    break;
                }
            }
            for(int j = 0; valid && j < 3; j++) {
                if(triplets[i][j] == target[j]) {
                    r[j] = true;
                }
            }
        }
        return r[0] && r[1] && r[2];
    }
}