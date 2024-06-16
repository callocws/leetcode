package leetcode._297;

import leetcode.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

  String s = "";

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    if (root == null) {
      s += "#!";
      return s;
    }
    s += "#" + root.val;
    serialize(root.left);
    serialize(root.right);
    return s;
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    int i = 1;
    for (; i < data.length() && data.charAt(i) != '#'; i++) {
      s = data.substring(i + 1);
    }
    if (data.charAt(i - 1) == '!') {
      return null;
    }
    TreeNode p = new TreeNode(Integer.parseInt(data.substring(1, i)));
    p.left = deserialize(s);
    p.right = deserialize(s);
    return p;
  }

  public static void main(String[] args) {
    // [1,2,3,null,null,4,5]
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.right.left = new TreeNode(4);
    root.right.right = new TreeNode(5);

    Codec ser = new Codec();
    Codec deser = new Codec();
    String serialize = ser.serialize(root);
    TreeNode ans = deser.deserialize(serialize);
    System.out.println(ans);

    System.out.println("ab".substring(2)+"c");
  }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));