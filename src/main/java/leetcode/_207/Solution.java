package leetcode._207;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

class Solution {
    class Node {
        int v;
        Set<Node> s = new HashSet();
        public Node(int v) {
            this.v = v;
        }
    }
    HashMap<Integer, Node> m = new HashMap();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i = 0; i < numCourses; i++) {
            m.put(i, new Node(i));
        }
        for(int i = 0; i < prerequisites.length; i++) {
            Node a = m.get(prerequisites[i][0]), b = m.get(prerequisites[i][1]);
            b.s.add(a);
            if(check(b, b.s)) {
                return false;
            }
        }
        return true;
    }
    boolean check(Node p, Set<Node> s) {
        if(s.isEmpty()) {
            return false;
        }
        if(s.contains(p)) {
            return true;
        }
        Set<Node> ns = new HashSet();
        for(Node n : s) {
            ns.addAll(n.s);
        }
        return check(p, ns);
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
        for(int i = 0; i < numCourses; i++) {
            m.put(i, new Node(i));
        }
        for(int i = 0; i < prerequisites.length; i++) {
            Node a = m.get(prerequisites[i][0]), b = m.get(prerequisites[i][1]);
            b.s.add(a);
        }
        for(int i = 0; i < numCourses; i++) {
            if (m.get(i).visited == 0 && checkCycle(m.get(i))) {
                return false;
            }
        }
        return true;
    }
    boolean checkCycle(Node p) {
        if(p.visited == 2 || p.s.isEmpty()) {
            return false;
        }
        if (p.visited == 1) {
            return true;
        }
        p.visited = 1;
        boolean b = false;
        for(Node n : p.s) {
            b |= checkCycle(n);
        }
        p.visited = 2;
        return b;
    }
}

class Solution2 {
    class Node {
        int v;
        boolean visited;
        Set<Node> s = new HashSet();
        public Node(int v) {
            this.v = v;
        }
    }
    HashMap<Integer, Node> m = new HashMap();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i = 0; i < numCourses; i++) {
            m.put(i, new Node(i));
        }
        for(int i = 0; i < prerequisites.length; i++) {
            Node a = m.get(prerequisites[i][0]), b = m.get(prerequisites[i][1]);
            b.s.add(a);
        }
        for(int i = 0; i < numCourses; i++) {
            if (!m.get(i).visited && checkCycle(m.get(i))) {
                return false;
            }
        }
        return true;
    }
    boolean checkCycle(Node p) {
        if(p.s.isEmpty()) {
            return false;
        }
        if (p.visited) {
            return true;
        }
        p.visited = true;
        for(Node n : p.s) {
            if(checkCycle(n)) {
                return true;
            }
        }
        p.s = Set.of();
        return false;
    }
}


// topological sort
class Solution3 {
    class Node {
        int v;
        int d;
        Set<Node> s = new HashSet();
        public Node(int v) {
            this.v = v;
        }
    }
    HashMap<Integer, Node> m = new HashMap();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i = 0; i < numCourses; i++) {
            m.put(i, new Node(i));
        }
        for(int i = 0; i < prerequisites.length; i++) {
            Node a = m.get(prerequisites[i][0]), b = m.get(prerequisites[i][1]);
            b.s.add(a);
            a.d++;
        }
        LinkedList<Node> l = new LinkedList();
        for(int i = 0; i < numCourses; i++) {
            if(m.get(i).d == 0) {
                l.add(m.get(i));
            }
        }
        for(;!l.isEmpty();) {
            Node p = l.pop();
            for(Node n : p.s) {
                if(--n.d == 0) {
                    l.add(n);
                }
            }
        }
        for(int i = 0; i < numCourses; i++) {
            if(m.get(i).d != 0) {
                return false;
            }
        }
        return true;
    }
}