package leetcode._167;

import java.util.HashMap;

// 167. Two Sum II - Input Array Is Sorted
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> m = new HashMap();
        for (int i = 0; i < numbers.length; i++) {
            m.put(numbers[i], i + 1);
        }

        for (int i = 0; i < numbers.length; i++) {
            Integer v = m.get(target - numbers[i]);
            if (v != null) {
                return new int[] {i + 1, v};
            }
        }
        return null;
    }
}

class Solution1 {
    public int[] twoSum(int[] numbers, int target) {
        for (int l = 0, r = numbers.length - 1; l < r; ) {
            int s = numbers[l] + numbers[r];
            if (s == target) {
                return new int[] {l + 1, r + 1};
            } else if (s < target) {
                l++;
            } else {
                r--;
            }
        }
        return null;
    }
}
