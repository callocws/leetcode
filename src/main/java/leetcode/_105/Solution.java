package leetcode._105;

import java.util.Arrays;
import leetcode.TreeNode;

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, 0, inorder.length - 1);
    }

    TreeNode buildTree(int[] A, int[] B, int i, int a, int b) {
        if (i >= A.length || a > b) {
            return null;
        }
        int j = a;
        for (; B[j] != A[i]; j++) {}
        TreeNode p = new TreeNode(A[i]),
                l = buildTree(A, B, i + 1, a, j - 1),
                r = buildTree(A, B, i + j - a + 1, j + 1, b);
        p.left = l;
        p.right = r;
        return p;
    }

    public static void main(String[] args) {
        int[] preorder = {1, 2, 3};
        int[] inorder = {2, 3, 1};
        System.out.println(new Solution().buildTree(preorder, inorder));
    }
}

class Solution1 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, 0, preorder.length);
    }

    TreeNode buildTree(int[] preorder, int[] inorder, int i, int j, int len) {
        if (len == 0) {
            return null;
        }
        TreeNode t = new TreeNode(preorder[i]);
        int j1 = j;
        for (; preorder[i] != inorder[j1]; j1++) {}
        t.left = buildTree(preorder, inorder, i + 1, j, j1 - j);
        t.right = buildTree(preorder, inorder, i + (j1 - j) + 1, j1 + 1, len - (j1 - j) - 1);
        return t;
    }

    public static void main(String[] args) {
        int[] preorder = {1, 2, 3};
        int[] inorder = {2, 3, 1};
        TreeNode.printTree(new Solution1().buildTree(preorder, inorder));
    }
}

class Solution2 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        TreeNode t = new TreeNode(preorder[0]);
        int i = 0;
        for (; preorder[0] != inorder[i]; i++) {}
        t.left =
                buildTree(
                        Arrays.copyOfRange(preorder, 1, i + 1), Arrays.copyOfRange(inorder, 0, i));
        t.right =
                buildTree(
                        Arrays.copyOfRange(preorder, i + 1, preorder.length),
                        Arrays.copyOfRange(inorder, i + 1, inorder.length));
        return t;
    }

    public static void main(String[] args) {
        int[] preorder = {1, 2, 3};
        int[] inorder = {2, 3, 1};
        TreeNode.printTree(new Solution2().buildTree(preorder, inorder));
    }
}
