package leetcode._875;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        long s = 0;
        int max = piles[0];
        for (int i = 0; i < piles.length; i++) {
            s += piles[i];
            max = Math.max(max, piles[i]);
        }
        int i = (int) (s / h), j = max;
        for (i = Math.max(1, i); i < j; ) {
            int m = (i + j) >> 1, t = 0;
            for (int l = 0; l < piles.length; l++) {
                t += piles[l] / m + (piles[l] % m > 0 ? 1 : 0);
            }
            if (t <= h) {
                j = m;
            } else {
                i = m + 1;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        // [332484035,524908576,855865114,632922376,222257295,690155293,112677673,679580077,337406589,290818316,877337160,901728858,679284947,688210097,692137887,718203285,629455728,941802184]
        System.out.println(
                new Solution()
                        .minEatingSpeed(
                                new int[] {
                                    332484035, 524908576, 855865114, 632922376, 222257295,
                                    690155293, 112677673, 679580077, 337406589, 290818316,
                                    877337160, 901728858, 679284947, 688210097, 692137887,
                                    718203285, 629455728, 941802184
                                },
                                823855818));
    }
}

class Solution1 {
    public int minEatingSpeed(int[] piles, int h) {
        int i = 1, j = 10000 * 100000;
        for (; i < j; ) {
            int m = (i + j) >> 1, t = 0;
            for (int pile : piles) {
                t += (pile + m - 1) / m;
            }
            if (t <= h) {
                j = m;
            } else {
                i = m + 1;
            }
        }
        return i;
    }
}

class Solution2 {
    public int minEatingSpeed(int[] piles, int h) {
        long i = 1, j = 1_000_000_000;
        for (; i <= j; ) {
            long m = (i + j) >> 1, t = 0;
            for (int pile : piles) {
                t += (pile + m - 1) / m;
            }
            if (t <= h) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return (int) i;
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution2()
                        .minEatingSpeed(new int[] {805306368, 805306368, 805306368}, 1000000000));
    }
}
