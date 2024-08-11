package leetcode._249;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// group-shifted-strings
public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> m = new HashMap();
        for(String str : strings) {
            m.computeIfAbsent(groupString(str), k -> new ArrayList()).add(str);
        }
        return new ArrayList<>(m.values());
    }

    String groupString(String str) {
        char cs[] = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < cs.length; i++) {
            sb.append((cs[i] - cs[i - 1] + 26) % 26);
            sb.append("-");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strings = {"abc","bcd","acef","xyz","az","ba","a","z"};
        List<List<String>> res = new Solution().groupStrings(strings);
        res.forEach(System.out::println);
        System.out.println();
    }
}