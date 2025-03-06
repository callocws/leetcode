package leetcode._173;

import java.util.Iterator;
import java.util.LinkedList;
import leetcode.TreeNode;

class BSTIterator {

    LinkedList<Integer> list = new LinkedList();
    Iterator<Integer> it;

    public BSTIterator(TreeNode root) {
        traverse(root);
        it = list.iterator();
    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        list.add(root.val);
        traverse(root.right);
    }

    public int next() {
        return it.next();
    }

    public boolean hasNext() {
        return it.hasNext();
    }
}
