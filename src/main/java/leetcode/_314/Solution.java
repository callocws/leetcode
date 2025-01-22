package leetcode._314;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import leetcode.TreeNode;

public class Solution {
    TreeMap<Integer, List<Integer>> verticalOrderMap = new TreeMap();
    TreeMap<Integer, ArrayList<int[]>> horizontalOrderMap = new TreeMap();

    public List<List<Integer>> verticalOrder(TreeNode root) {
        traverse(root, 0, 0);
        for (var list : horizontalOrderMap.values()) {
            for (var arr : list) {
                verticalOrderMap.computeIfAbsent(arr[0], k -> new ArrayList()).add(arr[1]);
            }
        }
        return new ArrayList(verticalOrderMap.values());
    }

    void traverse(TreeNode root, int row, int col) {
        if (root == null) {
            return;
        }
        horizontalOrderMap
                .computeIfAbsent(row, k -> new ArrayList())
                .add(new int[] {col, root.val});
        traverse(root.left, row + 1, col - 1);
        traverse(root.right, row + 1, col + 1);
    }
}

class Solution1 {
    Map<Integer, List<Integer>> verticalOrderMap = new HashMap<>();
    List<List<int[]>> horizontalOrderList = new ArrayList();

    public List<List<Integer>> verticalOrder(TreeNode root) {
        traverse(root, 0, 0);
        List<List<Integer>> result = new ArrayList();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (var list : horizontalOrderList) {
            for (var arr : list) {
                min = Math.min(min, arr[0]);
                max = Math.max(max, arr[0]);
                verticalOrderMap.computeIfAbsent(arr[0], k -> new ArrayList()).add(arr[1]);
            }
        }
        for (int i = min; i <= max; i++) {
            result.add(verticalOrderMap.get(i));
        }
        return result;
    }

    void traverse(TreeNode root, int row, int col) {
        if (root == null) {
            return;
        }
        if (horizontalOrderList.size() <= row) {
            horizontalOrderList.add(new ArrayList());
        }
        horizontalOrderList.get(row).add(new int[] {col, root.val});
        traverse(root.left, row + 1, col - 1);
        traverse(root.right, row + 1, col + 1);
    }
}

class Solution2 {
    Map<Integer, List<Integer>> verticalOrderMap = new HashMap<>();

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();

        List<TreeNode> list = new ArrayList();
        LinkedList<Integer> cols = new LinkedList();
        list.add(root);
        cols.add(0);
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (int i = 0; i < list.size(); ) {
            int size = list.size();
            for (; i < size; i++) {
                TreeNode p = list.get(i);
                int col = cols.removeFirst();

                if (p != null) {
                    verticalOrderMap.computeIfAbsent(col, k -> new ArrayList()).add(p.val);
                    min = Math.min(min, col);
                    max = Math.max(max, col);
                    list.add(p.left);
                    list.add(p.right);
                    cols.add(col - 1);
                    cols.add(col + 1);
                }
            }
        }

        for (int i = min; i <= max; i++) {
            result.add(verticalOrderMap.get(i));
        }
        return result;
    }
}
