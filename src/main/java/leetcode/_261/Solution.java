package leetcode._261;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean validTree(int n, int[][] edges) {
        Set<Integer> visited = new HashSet();
        Set<Integer> adj[] = new Set[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new HashSet<>();
        }
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        return !hasCycle(visited, adj, 0) && visited.size() == n;
    }

    boolean hasCycle(Set<Integer> visited, Set<Integer>[] adj, int i) {
        if (!visited.add(i)) {
            return true;
        }
        for (int j : adj[i]) {
            adj[j].remove(i);
            if (hasCycle(visited, adj, j)) {
                return true;
            }
        }
        return false;
    }
}

class Solution1 {
    public boolean validTree(int n, int[][] edges) {
        Set<Integer> visited = new HashSet();
        ArrayList<Integer> adj[] = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList();
        }
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        return !hasCycle(visited, adj, 0, -1) && visited.size() == n;
    }

    boolean hasCycle(Set<Integer> visited, ArrayList<Integer> adj[], int i, int pre) {
        if (visited.contains(i)) {
            return true;
        }
        visited.add(i);
        for (int j : adj[i]) {
            if (j != pre && hasCycle(visited, adj, j, i)) {
                return true;
            }
        }
        return false;
    }
}
