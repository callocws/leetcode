package leetcode._235;

import leetcode.TreeNode;

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            TreeNode t = p;
            p = q;
            q = t;
        }
        if (root == null) {
            return null;
        }
        if (p.val <= root.val && root.val <= q.val) {
            return root;
        }

        TreeNode t = lowestCommonAncestor(root.left, p, q);
        return t != null ? t : lowestCommonAncestor(root.right, p, q);
    }
}

class Solution1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            return lowestCommonAncestor(root, q, p);
        }
        if (root.val < p.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        if (root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }
}
