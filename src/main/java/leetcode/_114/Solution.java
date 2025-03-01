package leetcode._114;

import leetcode.TreeNode;

class Solution {
    TreeNode previous;
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode right = root.right;
        if (previous != null) {
            previous.right = root;
            previous.left = null;
        }
        previous = root;
        flatten(root.left);
        flatten(right);
    }
}

class Solution1 {
    TreeNode previous;
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = previous;
        root.left = null;
        previous = root;
    }
}
