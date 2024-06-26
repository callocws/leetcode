package leetcode._684;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        HashMap<Integer, ArrayList<Integer>> m = new HashMap();
        HashSet<Integer> visited = new HashSet();
        for(int[] e : edges) {
            addEdge(m, e[0], e[1]);
            addEdge(m, e[1], e[0]);
            visited.clear();
            if(hasCycle(m, visited, e[0], -1)) {
                return e;
            }
        }
        return null;
    }
    void addEdge(HashMap<Integer, ArrayList<Integer>> m, int i, int j) {
        ArrayList<Integer> arr = m.get(i);
        if (arr == null) {
            arr = new ArrayList();
        }
        arr.add(j);
        m.put(i, arr);
    }
    boolean hasCycle(HashMap<Integer, ArrayList<Integer>> m, HashSet<Integer> visited, int i, int pre) {
        if(visited.contains(i)) {
            return true;
        }
        visited.add(i);
        for(int j : m.get(i)) {
            if(j != pre && hasCycle(m, visited, j, i)) {
                return true;
            }
        }
        return false;
    }
}

class Solution1 {
    public int[] findRedundantConnection(int[][] edges) {
        int[] A = new int[edges.length + 1];
        for(int i = 1; i < A.length; i++) {
            A[i] = i;
        }
        for(int[] e : edges) {
            if(!merge(A, e[0], e[1])) {
                return e;
            }
        }
        return null;
    }
    int find(int[] A, int i) {
        if(A[i] != i) {
            A[i] = find(A, A[i]);
        }
        return A[i];
    }
    boolean merge(int[] A, int i, int j) {
        i = find(A, i);
        j = find(A, j);
        if(i == j) {
            return false;
        }
        A[i] = j;
        return true;
    }
}