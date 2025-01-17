package leetcode._1448;

import leetcode.TreeNode;

class Solution {
    int cnt;

    public int goodNodes(TreeNode root) {
        goodNodes(root, Integer.MIN_VALUE);
        return cnt;
    }

    void goodNodes(TreeNode p, int v) {
        if (p == null) {
            return;
        }
        if (p.val >= v) {
            cnt++;
            v = p.val;
        }
        goodNodes(p.left, v);
        goodNodes(p.right, v);
    }
}
