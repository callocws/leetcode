package leetcode._314;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import leetcode.TreeNode;

public class Solution {
    TreeMap<Integer, List<Integer>> verticalOrderMap = new TreeMap();
    TreeMap<Integer, ArrayList<int[]>> horizontalOrderMap = new TreeMap();
    public List<List<Integer>> verticalOrder(TreeNode root) {
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
        horizontalOrderMap.computeIfAbsent(row, k -> new ArrayList()).add(new int[]{col, root.val});
        traverse(root.left, row + 1, col - 1);
        traverse(root.right, row + 1, col + 1);
    }
}