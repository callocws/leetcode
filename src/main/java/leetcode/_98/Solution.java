package leetcode._98;

import leetcode.TreeNode;

class Solution {
    
    boolean b = true;
    public boolean isValidBST(TreeNode root) {
        f(root);
        return b;
    }

    int[] f(TreeNode p) {
        if(p == null) {
            return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE};
        }
        int[] l = f(p.left), r = f(p.right);
        if(!b || !((p.left == null || l[1] < p.val) && (p.right == null || p.val < r[0]))) {
            b = false;
            return new int[]{-1, -1};
        }
        return new int[] {p.left == null ? p.val : l[0], p.right == null ? p.val : r[1]};
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
        return f(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean f(TreeNode p, long min, long max) {
        return p == null || min < p.val && p.val < max && f(p.left, min, p.val) && f(p.right, p.val, max);
    }
}