package leetcode._226;


import leetcode.TreeNode;

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        TreeNode l = root.left, r = root.right;
        root.right = invertTree(l);
        root.left = invertTree(r);
        return root;
    }
}