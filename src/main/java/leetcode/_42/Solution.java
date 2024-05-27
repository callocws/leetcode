package leetcode._42;

class Solution {
    public int trap(int[] height) {
        int m = 0, h = 0;
        for(int i = 0; i < height.length; i++) {
            if(height[i] > height[h]) {
                h = i;
            }
        }

        for(int i = 0, l = 0; i < h; i++) {
            int k = Math.min(l, height[h]) - height[i];
            m += k < 0 ? 0 : k;
            l = Math.max(height[i], l);
        }

        for(int i = height.length - 1, r = 0; i > h; i--) {
            int k = Math.min(r, height[h]) - height[i];
            m += k < 0 ? 0 : k;
            r = Math.max(height[i], r);
        }

        return m;
    }
}

class Solution1 {
    public int trap(int[] height) {
        int m = 0, i = 0, j = height.length - 1, l = height[i], r = height[j];
        for(;i <= j;) {
            if(l <= r) {
                int k = l - height[i];
                m += k < 0 ? 0 : k;
                l = Math.max(l, height[i++]);
            } else {
                int k = r - height[j];
                m += k < 0 ? 0 : k;
                r = Math.max(r, height[j--]);
            }
        }
        return m;
    }
}