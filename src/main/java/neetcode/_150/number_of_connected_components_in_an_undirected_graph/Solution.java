package neetcode._150.number_of_connected_components_in_an_undirected_graph;

import java.util.ArrayList;

public class Solution {
    public int countComponents(int n, int[][] edges) {
        int cnt = 0;
        ArrayList<Integer>[] adj = new ArrayList[n];
        boolean visited[] = new boolean[n];
        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList();
        }
        for(int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                cnt++;
                dfs(visited, adj, i);
            }
        }
        return cnt;
    }

    void dfs(boolean visited[], ArrayList<Integer>[] adj, int i) {
        if(visited[i]) {
            return;
        }
        visited[i] = true;
        for(int j : adj[i]) {
            dfs(visited, adj, j);
        }
    }
}