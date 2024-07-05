package leetcode._332;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class Solution {

    class Node {
        String value;
        boolean visited;
        public Node(String value) {
            this.value = value;
        }
    }

    HashMap<String, ArrayList<Node>> m = new HashMap();
    int total = 0;
    LinkedList<String> r = new LinkedList();
    public List<String> findItinerary(List<List<String>> tickets) {
        total = tickets.size();
        for(List<String> t : tickets) {
            String s = t.get(0), e = t.get(1);
            ArrayList<Node> l = m.get(s);
            if(l == null) {
                l = new ArrayList<Node>();
            }
            l.add(new Node(e));
            m.put(s, l);
        }
        for(ArrayList<Node> l : m.values()) {
            l.sort((o1, o2) -> o1.value.compareTo(o2.value));
        }
        dfs("JFK", 0, new LinkedList());
        return r;
    }

    boolean dfs(String start, int cnt, LinkedList<String> l) {
        l.add(start);
        if(cnt == total) {
            r = new LinkedList(l);
            return true;
        }

        for(Node n : m.getOrDefault(start, new ArrayList<>())) {
            if(!n.visited) {
                n.visited = true;
              if (dfs(n.value, cnt + 1, l)) {
                return true;
              }
                n.visited = false;
            }
        }
        l.removeLast();
        return false;
    }
}