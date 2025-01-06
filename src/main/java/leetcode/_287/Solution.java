package leetcode._287;

class Solution {

    public int findDuplicate(int[] nums) {
        int p = 0, q = nums[nums[0]], i = 1, j;
        for (; p != q; ) {
            p = nums[p];
            q = nums[nums[q]];
        }
        for (p = nums[p]; p != q; p = nums[p], i++) {}
        for (p = q = j = 0; j == 0 || p != q; ) {
            if (j++ >= i) {
                q = nums[q];
            }
            p = nums[p];
        }
        return p;
    }
}

class Solution1 {

    public int findDuplicate(int[] nums) {
        int p = 0, q = 0;
        do {
            p = nums[p];
            q = nums[nums[q]];
        } while (p != q);

        for (p = 0; p != q; ) {
            p = nums[p];
            q = nums[q];
        }
        return p;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().findDuplicate(new int[] {1, 3, 4, 2, 2}));
        System.out.println(new Solution1().findDuplicate(new int[] {3, 3, 3, 3, 3}));
    }
}
