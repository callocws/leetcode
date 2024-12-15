package leetcode._1258;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

// sth wrong with this solution, the latter set may be in the same group with the previous set
class Solution {
    ArrayList<String> result = new ArrayList();
    HashSet<String>[] sets = new HashSet[10];

    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        for (int i = 0; i < 10; i++) {
            sets[i] = new HashSet();
        }
        for (List<String> strs : synonyms) {
            for (var set : sets) {
                if (set.isEmpty() || set.contains(strs.get(0)) || set.contains(strs.get(1))) {
                    set.addAll(strs);
                    break;
                }
            }
        }
        generateSentences(0, text.split(" "));
        result.sort(null);
        return result;
    }

    void generateSentences(int index, String[] words) {
        if (index == words.length) {
            result.add(String.join(" ", words));
            return;
        }
        for (var set : sets) {
            if (set.contains(words[index])) {
                for (var word : set) {
                    words[index] = word;
                    generateSentences(index + 1, words);
                }
                return;
            }
        }
        generateSentences(index + 1, words);
    }

    public static void main(String[] args) {
        var s = new Solution();
        System.out.println(
                s.generateSentences(
                        List.of(
                                List.of("happy", "joy"),
                                List.of("sad", "sorrow"),
                                List.of("joy", "cheerful")),
                        "I am happy today but was sad yesterday"));

        //        System.out.println(s.generateSentences(List.of(List.of("happy", "joy"),
        // List.of("cheerful", "glad")), "I am happy today but was sad yesterday"));
    }
}

class Solution1 {
    ArrayList<String> result = new ArrayList();
    HashMap<String, String> map = new HashMap();
    HashMap<String, HashSet<String>> mapSet = new HashMap();

    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        for (List<String> strs : synonyms) {
            for (String str : strs) {
                map.put(str, str);
            }
        }
        for (List<String> strs : synonyms) {
            union(strs.get(0), strs.get(1));
        }
        for (String str : map.keySet()) {
            mapSet.computeIfAbsent(find(str), k -> new HashSet<>()).add(str);
        }

        generateSentences(0, text.split(" "));
        result.sort(null);
        return result;
    }

    String find(String str) {
        String parent = map.get(str);
        if (parent == null || parent.equals(str)) {
            return parent;
        }
        parent = find(parent);
        map.put(str, parent);
        return parent;
    }

    void union(String a, String b) {
        String parent1 = find(a);
        String parent2 = find(b);
        map.put(parent1, parent2);
    }

    void generateSentences(int index, String[] words) {
        if (index == words.length) {
            result.add(String.join(" ", words));
            return;
        }
        String parent = find(words[index]);
        if (parent != null) {
            for (var word : mapSet.get(find(words[index]))) {
                words[index] = word;
                generateSentences(index + 1, words);
            }
            return;
        }
        generateSentences(index + 1, words);
    }

    public static void main(String[] args) {
        var s = new Solution1();
        //        System.out.println(s.generateSentences(List.of(List.of("happy", "joy"),
        // List.of("sad", "sorrow"), List.of("joy", "cheerful")), "I am happy today but was sad
        // yesterday"));

        System.out.println(
                s.generateSentences(
                        List.of(
                                List.of("happy", "joy"),
                                List.of("cheerful", "glad"),
                                List.of("happy", "glad")),
                        "I am happy today but was sad yesterday"));
    }
}
