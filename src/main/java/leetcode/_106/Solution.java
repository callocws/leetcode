package leetcode._106;

import java.util.HashMap;
import leetcode.TreeNode;

class Solution {
    int lastPostIndex;
    HashMap<Integer, Integer> map = new HashMap();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        lastPostIndex = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(inorder, postorder, 0, lastPostIndex);
    }

    TreeNode buildTree(int[] inorder, int[] postorder, int i, int j) {
        if (i > j) {
            return null;
        }
        int inIndex = map.get(postorder[lastPostIndex--]);
        TreeNode root = new TreeNode(inorder[inIndex]);
        root.right = buildTree(inorder, postorder, inIndex + 1, j);
        root.left = buildTree(inorder, postorder, i, inIndex - 1);
        return root;
    }
}
