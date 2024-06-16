package leetcode._124;

import leetcode.TreeNode;

class Solution {
    int m = -1000;
    public int maxPathSum(TreeNode root) {
        f(root);
        return m;
    }

    int f(TreeNode p) {
        if(p == null) {
            return 0;
        }
        int l = f(p.left), r = f(p.right);
        m = Math.max(m, p.val + Math.max(0, l) + Math.max(0, r));
        return p.val + Math.max(Math.max(0, l), Math.max(0, r));
    }
}