package leetcode._207;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Solution {
    class Node {
        int value;
        Set<Node> set = new HashSet();

        public Node(int v) {
            this.value = v;
        }
    }

    HashMap<Integer, Node> m = new HashMap();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            m.put(i, new Node(i));
        }
        for (int i = 0; i < prerequisites.length; i++) {
            Node a = m.get(prerequisites[i][0]), b = m.get(prerequisites[i][1]);
            b.set.add(a);
            if (checkCycle(b, b.set)) {
                return false;
            }
        }
        return true;
    }

    boolean checkCycle(Node p, Set<Node> set) {
        if (set.isEmpty()) {
            return false;
        }
        if (set.contains(p)) {
            return true;
        }
        Set<Node> ns = new HashSet();
        for (Node node : set) {
            ns.addAll(node.set);
        }
        return checkCycle(p, ns);
    }
}

// add visited cache
class Solution1 {
    class Node {
        int v;
        int visited;
        Set<Node> s = new HashSet();

        public Node(int v) {
            this.v = v;
        }
    }

    HashMap<Integer, Node> m = new HashMap();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            m.put(i, new Node(i));
        }
        for (int i = 0; i < prerequisites.length; i++) {
            Node a = m.get(prerequisites[i][0]), b = m.get(prerequisites[i][1]);
            b.s.add(a);
        }
        for (int i = 0; i < numCourses; i++) {
            if (m.get(i).visited == 0 && checkCycle(m.get(i))) {
                return false;
            }
        }
        return true;
    }

    boolean checkCycle(Node p) {
        if (p.visited == 2 || p.s.isEmpty()) {
            return false;
        }
        if (p.visited == 1) {
            return true;
        }
        p.visited = 1;
        boolean b = false;
        for (Node n : p.s) {
            b |= checkCycle(n);
        }
        p.visited = 2;
        return b;
    }
}

class Solution2 {
    class Node {
        int value;
        boolean visited;
        Set<Node> set = new HashSet();

        public Node(int value) {
            this.value = value;
        }
    }

    HashMap<Integer, Node> m = new HashMap();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            m.put(i, new Node(i));
        }
        for (int i = 0; i < prerequisites.length; i++) {
            Node a = m.get(prerequisites[i][0]), b = m.get(prerequisites[i][1]);
            b.set.add(a);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!m.get(i).visited && checkCycle(m.get(i))) {
                return false;
            }
        }
        return true;
    }

    boolean checkCycle(Node p) {
        if (p.set.isEmpty()) {
            return false;
        }
        if (p.visited) {
            return true;
        }
        p.visited = true;
        for (Node n : p.set) {
            if (checkCycle(n)) {
                return true;
            }
        }
        p.set = Set.of(); // mark as visited
        return false;
    }
}

// topological sort
class Solution3 {
    class Node {
        int value;
        int degree;
        Set<Node> set = new HashSet();

        public Node(int value) {
            this.value = value;
        }
    }

    HashMap<Integer, Node> m = new HashMap();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            m.put(i, new Node(i));
        }
        for (int i = 0; i < prerequisites.length; i++) {
            Node a = m.get(prerequisites[i][0]), b = m.get(prerequisites[i][1]);
            b.set.add(a);
            a.degree++;
        }
        LinkedList<Node> l = new LinkedList();
        for (int i = 0; i < numCourses; i++) {
            if (m.get(i).degree == 0) {
                l.add(m.get(i));
            }
        }
        for (; !l.isEmpty(); ) {
            Node p = l.pop();
            for (Node n : p.set) {
                if (--n.degree == 0) {
                    l.add(n);
                }
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (m.get(i).degree != 0) {
                return false;
            }
        }
        return true;
    }
}

class Solution3_1 {

    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    int degree[];

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        degree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            degree[prerequisites[i][0]]++;
        }
        List<Integer> queue = new LinkedList();
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }
        for (; !queue.isEmpty(); ) {
            int index = queue.removeFirst();
            for (int i : adj.get(index)) {
                if (--degree[i] == 0) {
                    queue.add(i);
                }
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
