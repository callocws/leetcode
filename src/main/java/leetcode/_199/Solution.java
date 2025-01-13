package leetcode._199;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import leetcode.TreeNode;

class Solution {

    List<Integer> result = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        rightSideView(root, 0);
        return result;
    }

    void rightSideView(TreeNode p, int level) {
        if (p == null) {
            return;
        }
        if (result.size() <= level) {
            result.add(p.val);
        }
        rightSideView(p.left, level + 1);
        rightSideView(p.right, level + 1);
        result.set(level, p.val);
    }
}

class Solution1 {

    LinkedList<Integer> result = new LinkedList();

    public List<Integer> rightSideView(TreeNode root) {
        rightSideView(root, 0);
        return result;
    }

    void rightSideView(TreeNode p, int level) {
        if (p == null) {
            return;
        }
        if (level >= result.size()) {
            result.add(p.val);
        }
        rightSideView(p.right, level + 1);
        rightSideView(p.left, level + 1);
    }
}
