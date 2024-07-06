package neetcode._150.alien_dictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Solution {
    public String alienOrder(String[] words) {
        Set<Character> set = new TreeSet(); // unrelational chars
        Map<Character, ArrayList<Character>> m = new TreeMap();
        HashMap<Character, Integer> degree = new HashMap();
        for(int i = 1; i < words.length; i++) {
            String a = words[i - 1], b = words[i];
            char as[] = a.toCharArray(), bs[] = b.toCharArray();
            int j = 0;
            for(; j < as.length && j < bs.length && as[j] == bs[j]; j++) {}
            if (j == bs.length) {
                return "";
            }
            if(j < as.length && j < bs.length) {
                m.computeIfAbsent(as[j], k -> new ArrayList()).add(bs[j]);
                degree.put(bs[j], degree.getOrDefault(bs[j], 0) + 1);
            }
        }
        for(String w : words) {
            for(char c : w.toCharArray()) {
                set.add(c);
            }
        }
        for(var v : m.keySet()) {
            set.remove(v);
        }
        for(var v : m.values()) {
            set.removeAll(v);
        }

        ArrayList<Character> q = new ArrayList();
        for(char c : m.keySet()) {
            if(degree.getOrDefault(c, 0) == 0) {
                q.add(c);
            }
        }
        if(q.isEmpty() && !degree.isEmpty()) {
            return "";
        }
        Set<Character> orderSet = new TreeSet();
        for(int i = 0; i < q.size() || !orderSet.isEmpty(); ) {
            if(i == q.size()) {
                q.addAll(orderSet);
                orderSet.clear();
                continue;
            }
          for(char c : m.getOrDefault(q.get(i), new ArrayList<>())) {
                int cnt = degree.get(c);
                if(cnt == 1) {
                    orderSet.add(c);
                }
                degree.put(c, cnt - 1);
            }
            i++;
        }
        
        StringBuilder sb = new StringBuilder();
        ArrayList<Character> leftq = new ArrayList(set);
        int i = 0, j = 0;
        for(; i < q.size() && j < leftq.size();) {
            if(q.get(i) < leftq.get(j)) {
                sb.append(q.get(i++));
            } else {
                sb.append(leftq.get(j++));
            }
        }
        for(; i < q.size();) {
            sb.append(q.get(i++));
        }
        for(; j < leftq.size();) {
            sb.append(leftq.get(j++));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // ["ab","abc"]
        System.out.println(new Solution().alienOrder(new String[]{"abc","ab"}));
        System.out.println(new Solution().alienOrder(new String[]{"ab","abc"}));
        System.out.println(new Solution().alienOrder(new String[]{"wrt","wrf","er","ett","rftt"}));
    }
}





