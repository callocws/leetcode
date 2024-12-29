package leetcode._347;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// 347. Top K Frequent Elements
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> h = new HashMap<>();
        for (int n : nums) {
            h.put(n, h.getOrDefault(n, 0) + 1);
        }
        var es = h.entrySet();
        return es.stream()
                .sorted((o1, o2) -> o2.getValue() - o1.getValue())
                .limit(k)
                .mapToInt(e -> e.getKey())
                .toArray();
    }
}

class Solution1 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        var entryList = new ArrayList<>(frequencyMap.entrySet());
        entryList.sort((a, b) -> b.getValue() - a.getValue());

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = entryList.get(i).getKey();
        }

        return result;
    }
}
