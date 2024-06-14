package leetcode._102;

import java.util.LinkedList;
import java.util.List;
import leetcode.TreeNode;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<List<Integer>> r = new LinkedList();
        LinkedList<TreeNode> l = new LinkedList();
        LinkedList<Integer> t = new LinkedList();
        if(root != null) {
            l.add(root);
        }
        TreeNode p, q = root, k = null;
        for (;!l.isEmpty();) {
            p = l.pop();
            t.add(p.val);
            if(p.left != null) {
                l.add(p.left);
                k = p.left;
            } 
            if(p.right != null) {
                l.add(p.right);
                k = p.right;
            } 

            if(p == q) {
                r.add(t);
                t = new LinkedList();
                q = k;
            }
        }
        return r;
    }
}
