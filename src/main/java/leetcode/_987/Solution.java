package leetcode._987;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import leetcode.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeMap<Integer, List<Integer>> verticalOrderMap = new TreeMap();
    TreeMap<Integer, ArrayList<int[]>> horizontalOrderMap = new TreeMap();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        traverse(root, 0, 0);
        for(var list : horizontalOrderMap.values()) {
            for(var arr : list) {
                verticalOrderMap.computeIfAbsent(arr[0], k -> new ArrayList()).add(arr[1]);
            }
        }
        return new ArrayList(verticalOrderMap.values());
    }
    void traverse(TreeNode root, int row, int col) {
        if(root == null) {
            return;
        }
        var hlist = horizontalOrderMap.computeIfAbsent(row, k -> new ArrayList<>());
        int i = hlist.size() - 1;
        for(; i >= 0 && (col != hlist.get(i)[0] || root.val < hlist.get(i)[1]); i--) {}
        hlist.add(i + 1, new int[]{col, root.val});

        traverse(root.left, row + 1, col - 1);
        traverse(root.right, row + 1, col + 1);
    }
}