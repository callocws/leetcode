package leetcode._127;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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

class Solution_dfs {
    ArrayList<Integer>[] adj;
    HashMap<Integer, Integer> visited = new HashMap<>();
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
        if(visited.getOrDefault(start, Integer.MAX_VALUE) <= n) {
            return;
        }
        if(start == end) {
            cnt = Math.min(cnt, n);
            return;
        }
        visited.put(start, n);
        for(int i : adj[start]) {
            dfs(i, end, n + 1);
        }
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

class Solution1 {
    ArrayList<Integer>[] adj;
    HashSet<Integer> visited = new HashSet();
    int cnt = 0;
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
        return bfs(wordList.size() - 1, endi);
    }
    int bfs(int start, int end) {
        ArrayList<Integer> q = new ArrayList<Integer>();
        q.add(start);
        for(int i = 0; i < q.size();) {
            int nums = q.size();
            cnt++;
            for(; i < nums; i++) {
                int p = q.get(i);
                if(visited.contains(p)) {
                    continue;
                }
                if(p == end) {
                    return cnt;
                }
                visited.add(p);
                for(int j : adj[p]) {
                    q.add(j);
                }
            }
        }
        return 0;
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

class Solution2 {
    HashSet<String> visited = new HashSet();
    int cnt = 0;
    HashMap<String, ArrayList<String>> m = new HashMap();
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);

        for(int i = 0; i < wordList.size(); i++) {
            String s = wordList.get(i);
            for(int j = 0; j < s.length(); j++) {
                String p = pattern(s, j);
                m.computeIfAbsent(p, k -> new ArrayList<String>()).add(s);
            }
        }
        return bfs(beginWord, endWord);
    }
    String pattern(String s, int i) {
        String start = i == 0 ? "" : s.substring(0, i);
        return start + "*" + s.substring(i + 1);
    }
    int bfs(String start, String end) {
        ArrayList<String> q = new ArrayList<String>();
        q.add(start);
        for(int i = 0; i < q.size();) {
            int nums = q.size();
            cnt++;
            for(; i < nums; i++) {
                String p = q.get(i);
                if(visited.contains(p)) {
                    continue;
                }
                if(p.equals(end)) {
                    return cnt;
                }
                visited.add(p);
                for(int j = 0; j < p.length(); j++) {
                    String pa = pattern(p, j);
                    for(String t : m.get(pa)) {
                        q.add(t);
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {

        Solution2 s = new Solution2();
        System.out.println(s.ladderLength("hit", "cog", new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"))));
    }
}