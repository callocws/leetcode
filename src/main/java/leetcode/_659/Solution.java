package leetcode._659;

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
