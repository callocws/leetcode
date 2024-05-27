package leetcode._11;

// 11. Container With Most Water
class Solution {
    public int maxArea(int[] height) {
        int m = 0;
        for(int i = 0, j = height.length - 1; i < j;) {
                int k = (j - i) * Math.min(height[i], height[j]);
                m = Math.max(m , k);
                if(height[i] < height[j]) {
                    i++;
                } else {
                    j--;
                }
        }
        return m;
    }
}