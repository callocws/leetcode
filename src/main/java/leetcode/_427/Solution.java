package leetcode._427;

// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(
            boolean val,
            boolean isLeaf,
            Node topLeft,
            Node topRight,
            Node bottomLeft,
            Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}

class Solution {
    public Node construct(int[][] grid) {
        return construct(grid, 0, 0, grid.length - 1, grid.length - 1);
    }

    Node construct(int[][] grid, int x1, int y1, int x2, int y2) {
        int t = grid[x1][y1];
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if (t != grid[i][j]) {
                    int mx = (x1 + x2) / 2, my = (y1 + y2) / 2;
                    return new Node(
                            false,
                            false,
                            construct(grid, x1, y1, mx, my),
                            construct(grid, x1, my + 1, mx, y2),
                            construct(grid, mx + 1, y1, x2, my),
                            construct(grid, mx + 1, my + 1, x2, y2));
                }
            }
        }
        return new Node(t == 1, true);
    }
}
