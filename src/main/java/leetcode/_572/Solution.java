package leetcode._572;

import leetcode.TreeNode;

class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (isSame(root, subRoot)) {
            return true;
        }

        return root != null && (isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot));
    }

    boolean isSame(TreeNode p, TreeNode q) {
        if (p == null) {
            return q == null;
        }

        if (q != null) {
            return p.val == q.val && isSame(p.left, q.left) && isSame(p.right, q.right);
        }
        return false;
    }
}

class Solution1 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return treeString(root).contains(treeString(subRoot));
    }

    String treeString(TreeNode root) {
        if (root == null) {
            return "N";
        }
        return String.format("#%s#%s%s", root.val, treeString(root.left), treeString(root.right));
    }
}
