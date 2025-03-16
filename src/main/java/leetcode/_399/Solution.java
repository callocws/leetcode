package leetcode._399;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    class Node {
        String key;
        double value;

        Node(String key, double value) {
            this.key = key;
            this.value = value;
        }
    }

    HashMap<String, List<Node>> adj = new HashMap();

    public double[] calcEquation(
            List<List<String>> equations, double[] values, List<List<String>> queries) {
        for (int i = 0; i < equations.size(); i++) {
            var equation = equations.get(i);
            adj.computeIfAbsent(equation.get(0), k -> new ArrayList())
                    .add(new Node(equation.get(1), values[i]));
            adj.computeIfAbsent(equation.get(1), k -> new ArrayList())
                    .add(new Node(equation.get(0), 1 / values[i]));
        }

        List<Double> result = new ArrayList();
        Set<String> visitedSet = new HashSet();
        for (var query : queries) {
            String a = query.get(0), b = query.get(1);
            if (!adj.containsKey(a) || !adj.containsKey(b)) {
                result.add(-1.0);
                continue;
            }
            result.add(dfs(a, b, visitedSet));
            visitedSet.clear();
        }

        double[] r = new double[result.size()];
        for (int i = 0; i < r.length; i++) {
            r[i] = result.get(i);
        }
        return r;
    }

    double dfs(String key, String target, Set<String> visitedSet) {
        if (!visitedSet.add(key)) {
            return -1;
        }
        if (key.equals(target)) {
            return 1;
        }
        for (var node : adj.get(key)) {
            double v = dfs(node.key, target, visitedSet);
            if (v != -1) {
                return node.value * v;
            }
        }
        return -1;
    }
}
