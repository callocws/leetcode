package leetcode._236;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import leetcode.TreeNode;

class Solution {
    HashMap<TreeNode, TreeNode> parentMap = new HashMap();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        traverse(null, root);
        Set<TreeNode> set = new HashSet();
        for (; p != null; p = parentMap.get(p)) {
            set.add(p);
        }
        for (; q != null; q = parentMap.get(q)) {
            if (set.contains(q)) {
                return q;
            }
        }
        return null;
    }

    void traverse(TreeNode parent, TreeNode p) {
        if (p == null) {
            return;
        }
        parentMap.put(p, parent);
        traverse(p, p.left);
        traverse(p, p.right);
    }
}
