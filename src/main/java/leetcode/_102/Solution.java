package leetcode._102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import leetcode.TreeNode;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<List<Integer>> r = new LinkedList();
        LinkedList<TreeNode> l = new LinkedList();
        LinkedList<Integer> t = new LinkedList();
        if (root != null) {
            l.add(root);
        }
        TreeNode p, q = root, k = null;
        for (; !l.isEmpty(); ) {
            p = l.pop();
            t.add(p.val);
            if (p.left != null) {
                l.add(p.left);
                k = p.left;
            }
            if (p.right != null) {
                l.add(p.right);
                k = p.right;
            }

            if (p == q) {
                r.add(t);
                t = new LinkedList();
                q = k;
            }
        }
        return r;
    }
}

class Solution1 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList();
        ArrayList<TreeNode> list = new ArrayList();
        if (root != null) {
            list.add(root);
        }
        for (int i = 0; i < list.size(); ) {
            int size = list.size();
            LinkedList<Integer> t = new LinkedList();
            for (; i < size; i++) {
                TreeNode p = list.get(i);
                if (p != null) {
                    list.add(p.left);
                    list.add(p.right);
                    t.add(p.val);
                }
            }
            if (!t.isEmpty()) {
                result.add(t);
            }
        }
        return result;
    }
}

class Solution2 {

    TreeMap<Integer, List<Integer>> map = new TreeMap();

    public List<List<Integer>> levelOrder(TreeNode root) {
        levelOrder(root, 0);
        return new ArrayList(map.values());
    }

    void levelOrder(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        map.computeIfAbsent(level, k -> new ArrayList()).add(root.val);
        levelOrder(root.left, level + 1);
        levelOrder(root.right, level + 1);
    }
}

class Solution2_1 {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        levelOrder(root, 0);
        return result;
    }

    void levelOrder(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (result.size() <= level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        levelOrder(root.left, level + 1);
        levelOrder(root.right, level + 1);
    }
}
