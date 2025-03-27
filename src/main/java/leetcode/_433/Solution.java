package leetcode._433;

import java.util.HashSet;
import java.util.Set;

class Solution {
    char[] cs = {'A', 'C', 'G', 'T'};

    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> set = new HashSet(), visitedSet = new HashSet();
        for (var gene : bank) {
            set.add(gene);
        }
        int cnt = dfs(startGene, endGene, set, visitedSet);
        return cnt >= 100 ? -1 : cnt;
    }

    int dfs(String startGene, String endGene, Set<String> set, Set<String> visitedSet) {
        if (startGene.equals(endGene)) {
            return 0;
        }
        int m = 100;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 4; j++) {
                if (startGene.charAt(i) == cs[j]) {
                    continue;
                }
                String s = startGene.substring(0, i) + cs[j] + startGene.substring(i + 1);
                if (!set.contains(s)) {
                    continue;
                }
                if (!visitedSet.add(s)) {
                    continue;
                }
                m = Math.min(m, 1 + dfs(s, endGene, set, visitedSet));
            }
        }
        return m;
    }

    public static void main(String[] args) {
        var s = new Solution();
        System.out.println(s.minMutation("AACCGGTT", "AACCGGTA", new String[] {"AACCGGTA"}));
        System.out.println(
                s.minMutation(
                        "AACCGGTT", "AAACGGTA", new String[] {"AACCGGTA", "AACCGCTA", "AAACGGTA"}));
    }
}
