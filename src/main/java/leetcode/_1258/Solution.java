package leetcode._1258;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Solution {
    ArrayList<String> result = new ArrayList();
    HashSet<String>[] sets = new HashSet[10];
    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        for(int i = 0; i < 10; i++) {
            sets[i] = new HashSet();
        }
        for(List<String> strs : synonyms) {
            for(var set : sets) {
                if(set.isEmpty() || set.contains(strs.get(0)) || set.contains(strs.get(1))) {
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
        if(index == words.length) {
            result.add(String.join(" ", words));
            return;
        }
        for(var set : sets) {
            if(set.contains(words[index])) {
                for(var word : set) {
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
        System.out.println(s.generateSentences(List.of(List.of("happy", "joy"), List.of("sad", "sorrow"), List.of("joy", "cheerful")), "I am happy today but was sad yesterday"));


//        System.out.println(s.generateSentences(List.of(List.of("happy", "joy"), List.of("cheerful", "glad")), "I am happy today but was sad yesterday"));
    }
}

class Solution1 {
    ArrayList<String> result = new ArrayList();
    HashMap<String, String> map = new HashMap();
    HashMap<String, HashSet<String>> mapSet = new HashMap();
    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        for(List<String> strs : synonyms) {
            for(String str : strs) {
                map.put(str, str);
            }
        }
        for(List<String> strs : synonyms) {
            add(strs.get(0), strs.get(1));
        }
        for(List<String> strs : synonyms) {
            for(String str : strs) {
                mapSet.computeIfAbsent(findParent(str), k -> new HashSet<String>()).add(str);
            }
        }

        generateSentences(0, text.split(" "));
        result.sort(null);
        return result;
    }

    String findParent(String str) {
        String parent = map.get(str);
        if(parent == null || parent == str) {
            return parent;
        }
        parent = findParent(parent);
        map.put(str, parent);
        return parent;
    }

    void add(String a, String b) {
        String parent1 = findParent(a);
        String parent2 = findParent(b);
        map.put(a, parent2);
    }

    void generateSentences(int index, String[] words) {
        if(index == words.length) {
            result.add(String.join(" ", words));
            return;
        }
        String parent = findParent(words[index]);
        if(parent != null) {
            for(var word : mapSet.get(findParent(words[index]))) {
                words[index] = word;
                generateSentences(index + 1, words);
            }
            return;
        }
        generateSentences(index + 1, words);
    }

    public static void main(String[] args) {
        var s = new Solution1();
        System.out.println(s.generateSentences(List.of(List.of("happy", "joy"), List.of("sad", "sorrow"), List.of("joy", "cheerful")), "I am happy today but was sad yesterday"));


//        System.out.println(s.generateSentences(List.of(List.of("happy", "joy"), List.of("cheerful", "glad")), "I am happy today but was sad yesterday"));
    }

}

