package leetcode;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

//49. Group Anagrams
class _49 {

}

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
    System.out.println(new Solution().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
  }

}