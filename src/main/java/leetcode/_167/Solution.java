package leetcode._167;

import java.util.HashMap;

// 167. Two Sum II - Input Array Is Sorted
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> m = new HashMap();
        for(int i = 0; i < numbers.length; i++) {
            m.put(numbers[i], i + 1);
        }

        for(int i = 0; i < numbers.length; i++) { // can combine the logic together
            Integer v = m.get(target - numbers[i]);
            if(v != null) {
                return new int[]{i + 1, v};
            }
        }
        return null;
    }
}