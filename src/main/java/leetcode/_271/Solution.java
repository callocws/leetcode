package leetcode._271;

import java.util.LinkedList;
import java.util.List;

// Encode and Decode Strings
class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s + "\n");
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        LinkedList<String> l = new LinkedList();
        char[] cs = str.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (char c : cs) {
            if (c == '\n') {
                l.add(sb.toString());
                sb = new StringBuilder();
            } else {
                sb.append(c);
            }
        }
        return l;
    }

    public static void main(String[] args) {
        List<String> list = List.of("a", "b", "c");
        //        List<String> list = List.of("");
        String encode = new Solution().encode(list);
        System.out.println(encode);
        System.out.println(new Solution().decode(encode));
    }
}

class Solution1 {
    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length() + "#" + s);
        }
        return sb.toString();
    }

    /*
     * @param str: A string
     * @return: decodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        LinkedList<String> l = new LinkedList();
        char[] cs = str.toCharArray();

        for (int i = 0, j = 0; j < cs.length; ) {
            for (; cs[j] != '#'; j++) {}
            int k = Integer.parseInt(new String(cs, i, j - i));
            l.add(new String(cs, j + 1, k));
            i = j = j + k + 1;
        }
        return l;
    }
}
