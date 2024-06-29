package leetcode._152;

class Solution {
    int product = 0;
    public int maxProduct(int[] nums) {
        int product = nums[0], a, b, i;
        for(a = b = 1, i = 0; i < nums.length; i++) {
            int v[] = extreme(a * nums[i], b * nums[i], nums[i]);
            a = v[1];
            b = v[0];
            product = Math.max(product, a);
        }
        return product;
    }

    public int[] extreme(int... A) {
        int max, min, i;
        for(max = min = A[0], i = 0; i < A.length; i++) {
            max = Math.max(max, A[i]);
            min = Math.min(min, A[i]);
        }
        return new int[]{min, max};
    }

    public static void main(String[] args) {
        // [0,10,10,10,10,10,10,10,10,10,-10,10,10,10,10,10,10,10,10,10,0]
        System.out.println(new Solution().maxProduct(new int[]{0,10,10,10,10,10,10,10,10,10,-10,10,10,10,10,10,10,10,10,10,0}));
        System.out.println(new Solution().maxProduct(new int[]{2,3,-2,4}));
    }
}