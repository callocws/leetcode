package leetcode._13;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public int romanToInt(String str) {
        HashMap<Character, Integer> map = new HashMap();
        List<String> l = new LinkedList();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        char cs[] = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        sb.append(cs[0]);
        for (int i = 1; i < cs.length; i++) {
            if (map.get(cs[i]) <= map.get(cs[i - 1])) {
                l.add(sb.toString());
                sb = new StringBuilder();
            }
            sb.append(cs[i]);
        }
        if (sb.length() > 0) {
            l.add(sb.toString());
        }
        int sum = 0;
        for (String s : l) {
            for (int i = 0; i < s.length(); i++) {
                int t = map.get(s.charAt(i));
                if (i != s.length() - 1) {
                    t *= -1;
                }
                sum += t;
            }
        }
        return sum;
    }
}

class Solution1 {
    public int romanToInt(String str) {
        HashMap<Character, Integer> map = new HashMap();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int sum = 0;
        char cs[] = str.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (i < cs.length - 1 && map.get(cs[i]) < map.get(cs[i + 1])) {
                sum += map.get(cs[i]) * -1;
            } else {
                sum += map.get(cs[i]);
            }
        }
        return sum;
    }
}
