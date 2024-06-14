package leetcode._572;

import leetcode.TreeNode;

class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(isSame(root, subRoot)) {
            return true;
        }

        return root != null && (isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot));
    }

    boolean isSame(TreeNode p, TreeNode q) {
        if(p == null) {
            return q == null;
        }

        if(q != null) {
            return p.val == q.val && isSame(p.left, q.left) && isSame(p.right, q.right);
        }
        return false;
    }
}