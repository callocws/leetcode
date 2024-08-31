package leetcode._230;

import leetcode.TreeNode;

class Solution {
    int i = 0;

    public int kthSmallest(TreeNode root, int k) {
        return f(root, k);
    }

    int f(TreeNode p, int k) {
        if (p == null) {
            return -1;
        }
        int t = f(p.left, k);
        if (t >= 0) {
            return t;
        }
        if (++i == k) {
            return p.val;
        }
        t = f(p.right, k);
        return t >= 0 ? t : -1;
    }
}

class Solution1 {
    int i = 0;
    int cnt = 0;

    public int kthSmallest(TreeNode root, int k) {
        f(root, k);
        return cnt;
    }

    void f(TreeNode p, int k) {
        if (p == null) {
            return;
        }
        f(p.left, k);
        if (++i == k) {
            cnt = p.val;
            return;
        }
        f(p.right, k);
    }
}

class Solution2 {
    int i = 0, t;

    public int kthSmallest(TreeNode root, int k) {
        return root == null
                ? -1
                : (t = kthSmallest(root.left, k)) != -1
                        ? t
                        : (++i == k) ? root.val : (t = kthSmallest(root.right, k)) != -1 ? t : -1;
    }
}
