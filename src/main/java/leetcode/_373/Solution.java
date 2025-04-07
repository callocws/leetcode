package leetcode._373;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new LinkedList();
        Set<String> set = new HashSet();
        PriorityQueue<int[]> pq =
                new PriorityQueue<>(
                        (A, B) -> nums1[A[0]] + nums2[A[1]] - nums1[B[0]] - nums2[B[1]]);
        pq.add(new int[] {0, 0});

        for (; result.size() < k; ) {
            int A[] = pq.remove(), i = A[0], j = A[1];
            result.add(List.of(nums1[i], nums2[j]));
            if (i + 1 < nums1.length && set.add((i + 1) + ":" + j)) {
                pq.add(new int[] {i + 1, j});
            }
            if (j + 1 < nums2.length && set.add(i + ":" + (j + 1))) {
                pq.add(new int[] {i, j + 1});
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution().kSmallestPairs(new int[] {1, 7, 11}, new int[] {2, 4, 6}, 3));
    }
}
