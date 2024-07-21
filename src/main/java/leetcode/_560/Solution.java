package leetcode._560;

import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, ArrayList<Integer>> m = new HashMap();
        int prefixSum[] = new int[nums.length + 1], i = 1, cnt = 0;
        for(prefixSum[0] = nums[0]; i <= nums.length; i++) {
            prefixSum[i] = nums[i - 1] + prefixSum[i - 1];
            m.computeIfAbsent(prefixSum[i], key -> new ArrayList()).add(i);
        }
        for(i = 0; i <= nums.length; i++) {
            ArrayList<Integer> indexs = m.get(prefixSum[i] + k);
            if(indexs != null) {
                int j = 0;
                for(int index : indexs) {
                    if(index > i) {
                        cnt += indexs.size() - j;
                        break;
                    }
                    j++;
                }
            }
        }
        return cnt;
    }
}