package leetcode._139;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Solution {
    
    class Node {
        HashMap<Character, Node> m = new HashMap();
        boolean isEnd;

        void put(String word) {
            if(word.isEmpty()) {
                isEnd = true;
                return;
            }
            char c = word.charAt(0);
            Node n = m.get(c);
            if(n == null) {
                n = new Node();
            }
            m.put(c, n);
            n.put(word.substring(1));
        }

        boolean get(String s, Node root) {
            if(s.isEmpty() && isEnd) {
                return true;
            }
            char c = s.isEmpty() ? '-' : s.charAt(0);
            Node n = m.get(c);
            if(n == null) {
                return false;
            }
            String left = s.substring(1);
            return n.isEnd && root.get(left, root) || n.get(left, root);
        }
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Node root = new Node();
        for(String word : wordDict) {
            root.put(word);
        }
        return root.get(s, root);
    }

    public static void main(String[] args) {
        // s =
        //"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
        //wordDict =
        //["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
        System.out.println(new Solution().wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                List.of("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa")));
    }
}


class Solution1 {

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet(wordDict);
        return contains(s, set);
    }

    boolean contains(String s, HashSet<String> set) {
        if(s.isEmpty()) {
            return true;
        }
        for(int i = 1; i <= s.length(); i++) {
            if(set.contains(s.substring(0, i)) && contains(s.substring(i), set)) {
                return true;
            }
        }
        return false;
    }
}




