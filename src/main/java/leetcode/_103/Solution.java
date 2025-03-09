package leetcode._103;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import leetcode.TreeNode;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList();
        List<TreeNode> list = new ArrayList();
        list.add(root);
        boolean dir = true;
        for (int i = 0; i < list.size(); ) {
            int size = list.size();
            List<Integer> tmpResult = new LinkedList();

            for (int j = i; j < size; j++) {
                TreeNode p = list.get(j);
                if (p != null) {
                    list.add(p.left);
                    list.add(p.right);
                }
            }

            for (int j = i; j < size; j++) {
                int t = dir ? j : size - 1 - (j - i);
                TreeNode p = list.get(t);
                if (p != null) {
                    tmpResult.add(p.val);
                }
            }
            if (!tmpResult.isEmpty()) {
                result.add(tmpResult);
            }
            dir = dir ? false : true;
            i = size;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 创建测试用例的树结构
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // 实际结果
        List<List<Integer>> result = solution.zigzagLevelOrder(root);

        // 断言结果
        System.out.println(result);
    }
}

class Solution1 {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        traverse(root, 0);
        return result;
    }

    void traverse(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (result.size() == level) {
            result.add(new LinkedList());
        }
        if (level % 2 == 0) {
            result.get(level).add(root.val);
        } else {
            result.get(level).addFirst(root.val);
        }
        traverse(root.left, level + 1);
        traverse(root.right, level + 1);
    }
}
