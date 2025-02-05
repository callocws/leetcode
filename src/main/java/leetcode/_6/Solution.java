package leetcode._6;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<Character>[] list = new List[numRows];
        for (int i = 0; i < numRows; i++) {
            list[i] = new LinkedList();
        }
        int i = 0, dir = 1;
        for (char c : s.toCharArray()) {
            list[i].add(c);
            if (i == 0 && dir == -1) {
                dir = 1;
            }
            if (i == numRows - 1 && dir == 1) {
                dir = -1;
            }
            i = i + dir;
        }
        StringBuilder sb = new StringBuilder();
        for (List<Character> l : list) {
            for (char c : l) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}

class Solution1 {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder[] list = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            list[i] = new StringBuilder();
        }
        int i = 0, dir = -1;
        for (char c : s.toCharArray()) {
            list[i].append(c);
            if (i == 0 || i == numRows - 1) {
                dir *= -1;
            }
            i = i + dir;
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder str : list) {
            sb.append(str);
        }
        return sb.toString();
    }
}
