package leetcode._127;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    ArrayList<Integer>[] adj;
    HashSet<Integer> visited = new HashSet();
    int cnt = 6000;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        adj = new ArrayList[wordList.size()];

        int endi = -1;
        for(int i = 0; i < wordList.size(); i++) {
            adj[i] = new ArrayList();
            if(wordList.get(i).equals(endWord)) {
                endi = i;
            }
        }
        if(endi == -1) {
            return 0;
        }
        for(int i = 0; i < wordList.size(); i++) {
            for(int j = i + 1; j < wordList.size(); j++) {
                String a = wordList.get(i), b = wordList.get(j); 
                if(isDifferBy1Letter(a, b)) {
                    adj[i].add(j);
                    adj[j].add(i);
                }
            }
        }
        dfs(wordList.size() - 1, endi, 1);
        return cnt == 6000 ? 0 : cnt;
    }
    void dfs(int start, int end, int n) {
        if(visited.contains(start)) {
            return;
        }
        if(start == end) {
            cnt = Math.min(cnt, n);
            return;
        }
        visited.add(start);
        for(int i : adj[start]) {
            dfs(i, end, n + 1);
        }
        visited.remove(start);
    }
    boolean isDifferBy1Letter(String s1, String s2) {
        int cnt = 0;
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                cnt++;
            }
        }
        return cnt <= 1;
    }
}