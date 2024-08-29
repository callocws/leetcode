package leetcode._102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
        LinkedList<List<Integer>> r = new LinkedList();
        ArrayList<TreeNode> l = new ArrayList();
        if (root != null) {
            l.add(root);
        }
        for (int i = 0; i < l.size(); ) {
            int size = l.size();
            LinkedList<Integer> t = new LinkedList();
            for (; i < size; i++) {
                TreeNode p = l.get(i);
                if (p != null) {
                    l.add(p.left);
                    l.add(p.right);
                    t.add(p.val);
                }
            }
            if (!t.isEmpty()) {
                r.add(t);
            }
        }
        return r;
    }
}
