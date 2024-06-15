package leetcode._1448;

import leetcode.TreeNode;

class Solution {
    int s;
    public int goodNodes(TreeNode root) {
        f(root, Integer.MIN_VALUE);
        return s;
    }

    void f(TreeNode p, int v) {
        if(p == null) {
            return;
        }
        int t = Math.max(p.val, v);
        if(p.val >= v) {
            s++;
        }
        f(p.left, t);
        f(p.right, t);
    }
}