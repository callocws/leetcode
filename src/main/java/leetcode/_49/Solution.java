package leetcode._49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<String> A = new LinkedList(Arrays.asList(strs)), t;
        List<List<String>> L = new LinkedList();

        String a = null;
        for (; A.size() > 0; ) {
            Iterator<String> it = A.iterator();
            a = it.next();
            it.remove();

            t = new LinkedList();
            t.add(a);

            for (; it.hasNext(); ) {
                String b = it.next();
                if (equals(a, b)) {
                    t.add(b);
                    it.remove();
                }
            }
            L.add(t);
        }
        return L;
    }

    boolean equals(String a, String b) {
        char[] A = a.toCharArray(), B = b.toCharArray();
        Arrays.sort(A);
        Arrays.sort(B);
        return new String(A).equals(new String(B));
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution()
                        .groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}

class Solution1 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap();
        for (String str : strs) {
            char[] cs = str.toCharArray();
            Arrays.sort(cs);
            map.computeIfAbsent(new String(cs), k -> new ArrayList()).add(str);
        }
        return new ArrayList(map.values());
    }
}
