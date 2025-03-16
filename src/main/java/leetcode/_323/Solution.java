package leetcode._323;

import java.util.ArrayList;
import java.util.HashSet;

public class Solution {
    public int countComponents(int n, int[][] edges) {
        int cnt = 0;
        ArrayList<Integer>[] adj = new ArrayList[n];
        boolean visited[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList();
        }
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                cnt++;
                dfs(visited, adj, i);
            }
        }
        return cnt;
    }

    void dfs(boolean visited[], ArrayList<Integer>[] adj, int i) {
        if (visited[i]) {
            return;
        }
        visited[i] = true;
        for (int j : adj[i]) {
            dfs(visited, adj, j);
        }
    }
}

// union find
class Solution1 {
    public int countComponents(int n, int[][] edges) {
        int[] A = new int[n];
        HashSet<Integer> s = new HashSet();
        for (int i = 0; i < n; i++) {
            A[i] = i;
        }
        for (int[] e : edges) {
            union(A, e[0], e[1]);
        }
        for (int i = 0; i < n; i++) {
            s.add(find(A, i));
        }
        return s.size();
    }

    int find(int[] A, int i) {
        if (A[i] != i) {
            A[i] = find(A, A[i]);
        }
        return A[i];
    }

    void union(int[] A, int i, int j) {
        A[find(A, i)] = find(A, j);
    }
}

class Solution2 {
    public int countComponents(int n, int[][] edges) {
        int[] A = new int[n], R = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = i;
            R[i] = 1;
        }
        for (int[] e : edges) {
            if (merge(A, R, e[0], e[1])) {
                n--;
            }
        }
        return n;
    }

    int find(int[] A, int i) {
        if (A[i] != i) {
            A[i] = find(A, A[i]);
        }
        return A[i];
    }

    boolean merge(int[] A, int[] R, int i, int j) {
        i = find(A, i);
        j = find(A, j);
        if (i == j) {
            return false;
        }
        if (R[i] >= R[j]) {
            A[j] = i;
            R[i] += R[j];
        } else {
            A[i] = j;
            R[j] += R[i];
        }
        return true;
    }
}
