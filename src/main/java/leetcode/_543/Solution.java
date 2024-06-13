package leetcode._543;

import leetcode.TreeNode;

class Solution {
    int m = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        f(root);
        return m;
    }

    public int f(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int l = f(root.left), r = f(root.right);
        m = Math.max(m, l + r);
        return Math.max(l, r) + 1;
    }
}