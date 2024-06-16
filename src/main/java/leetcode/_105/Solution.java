package leetcode._105;

import leetcode.TreeNode;

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return f(preorder, inorder, 0, 0, inorder.length - 1);
    }

    TreeNode f(int[] A, int[] B, int i, int a, int b) {
        if(i >= A.length || a > b) {
            return null;
        }
        int j = a;
        for(;B[j] != A[i]; j++) {}
        TreeNode p = new TreeNode(A[i]), l = f(A, B, i + 1, a, j - 1), r = f(A, B, i + j - a + 1, j + 1, b);
        p.left = l;
        p.right = r;
        return p;
    }


    public static void main(String[] args) {
        int[] preorder = {1, 2, 3};
        int[] inorder = {2, 3, 1};
        System.out.println(new Solution().buildTree(preorder, inorder));
    }
}