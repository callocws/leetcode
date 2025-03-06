package leetcode._129;

import leetcode.TreeNode;

class Solution {
    int sum;

    public int sumNumbers(TreeNode root) {
        sumNumbers(root, 0);
        return sum;
    }

    void sumNumbers(TreeNode root, int num) {
        if (root == null) {
            return;
        }
        num = num * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += num;
            return;
        }
        sumNumbers(root.left, num);
        sumNumbers(root.right, num);
    }
}
