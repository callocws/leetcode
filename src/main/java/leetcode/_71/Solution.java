package leetcode._71;

import java.util.LinkedList;

class Solution {
    public String simplifyPath(String path) {
        String ps[] = path.split("/");
        LinkedList<String> l = new LinkedList();
        for (String s : ps) {
            if (s.isEmpty()) {
                continue;
            }
            if (s.charAt(0) == '.') {
                if (s.length() == 1) {
                    continue;
                }
                if (s.length() == 2 && s.charAt(1) == '.') {
                    if (!l.isEmpty()) {
                        l.removeLast();
                    }
                } else {
                    l.add(s);
                }
            } else {
                l.add(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String s : l) {
            sb.append("/" + s);
        }
        if (sb.length() == 0) {
            sb.append('/');
        }
        return sb.toString();
    }
}

class Solution1 {
    public String simplifyPath(String path) {
        String paths[] = path.split("/");
        LinkedList<String> list = new LinkedList();
        for (String s : paths) {
            if (s.equals("..")) {
                if (!list.isEmpty()) {
                    list.removeLast();
                }
            } else if (!s.isEmpty() && !s.equals(".")) {
                list.add(s);
            }
        }
        if (list.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append("/" + s);
        }
        return sb.toString();
    }
}
