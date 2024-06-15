package leetcode._199;

import java.util.LinkedList;
import java.util.List;
import leetcode.TreeNode;

class Solution {

    LinkedList<Integer> l = new LinkedList();
    public List<Integer> rightSideView(TreeNode root) {
        f(root, 0);
        return l;
    }

    void f(TreeNode p, int h) {
        if(p == null) {
            return;
        }
        if(l.size() <= h) {
            l.add(p.val);
        }
        f(p.left, h + 1);
        f(p.right, h + 1);
        l.set(h, p.val);
    }
}