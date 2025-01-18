package leetcode._98;

import leetcode.TreeNode;

class Solution {

    boolean isValidBST = true;

    public boolean isValidBST(TreeNode root) {
        BST_Range(root);
        return isValidBST;
    }

    int[] BST_Range(TreeNode p) {
        if (p == null) {
            return new int[] {Integer.MIN_VALUE, Integer.MAX_VALUE};
        }
        int[] left = BST_Range(p.left), right = BST_Range(p.right);
        if (!isValidBST
                || !((p.left == null || left[1] < p.val) && (p.right == null || p.val < right[0]))) {
            isValidBST = false;
            return new int[] {-1, -1};
        }
        return new int[] {p.left == null ? p.val : left[0], p.right == null ? p.val : right[1]};
    }

    public static void main(String[] args) {
        // [2,1,3]
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(new Solution().isValidBST(root));
    }
}

class Solution1 {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean isValidBST(TreeNode p, long min, long max) {
        return p == null
                || min < p.val
                        && p.val < max
                        && isValidBST(p.left, min, p.val)
                        && isValidBST(p.right, p.val, max);
    }
}

class Solution2 {
    long m = Long.MIN_VALUE, k;

    public boolean isValidBST(TreeNode root) {
        return root == null
                || isValidBST(root.left) && (k = m) < (m = root.val) && isValidBST(root.right);
    }
}
