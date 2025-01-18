package leetcode._230;

import leetcode.TreeNode;

class Solution {
    int i = 0;

    public int kthSmallest(TreeNode root, int k) {
        return traverse(root, k);
    }

    int traverse(TreeNode p, int k) {
        if (p == null) {
            return -1;
        }
        int t = traverse(p.left, k);
        if (t >= 0) {
            return t;
        }
        if (++i == k) {
            return p.val;
        }
        t = traverse(p.right, k);
        return t >= 0 ? t : -1;
    }
}

class Solution1 {
    int i = 0;
    int cnt = 0;

    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return cnt;
    }

    void traverse(TreeNode p, int k) {
        if (p == null) {
            return;
        }
        traverse(p.left, k);
        if (++i == k) {
            cnt = p.val;
            return;
        }
        traverse(p.right, k);
    }
}

class Solution2 {
    int i = 0, tmp;

    public int kthSmallest(TreeNode root, int k) {
        return root == null
                ? -1
                : (tmp = kthSmallest(root.left, k)) != -1
                        ? tmp
                        : (++i == k)
                                ? root.val
                                : (tmp = kthSmallest(root.right, k)) != -1 ? tmp : -1;
    }
}
