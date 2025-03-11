package leetcode._836;

class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return isInterjected(rec1[0], rec1[2], rec2[0], rec2[2])
                && isInterjected(rec1[1], rec1[3], rec2[1], rec2[3]);
    }

    boolean isInterjected(int start1, int end1, int start2, int end2) {
        return start2 < end1 && start1 < end2;
    }
}
