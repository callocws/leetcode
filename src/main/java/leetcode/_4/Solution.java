package leetcode._4;

class Solution {

    public double findMedianSortedArrays(int[] A, int[] B) {
        if (A.length > B.length) {
            int[] t = A;
            A = B;
            B = t;
        }

        for (int i = 0, j = A.length - 1; ; ) {
            int m1 = (i + j) >> 1, m2 = (A.length + B.length + 1) / 2 - m1 - 2;
            double Al = min(m1, A), Ar = max(m1 + 1, A), Bl = min(m2, B), Br = max(m2 + 1, B);

            if (Al > Br) {
                j = m1 - 1;
            } else if (Ar < Bl) {
                i = m1 + 1;
            } else {
                if ((A.length + B.length) % 2 == 0) {
                    return (Double.max(Al, Bl) + Double.min(Ar, Br)) / 2;
                } else {
                    return Double.max(Al, Bl);
                }
            }
        }
    }

    double min(int i, int[] A) {
        return i < 0 ? Integer.MIN_VALUE : (double) A[i];
    }

    double max(int i, int[] A) {
        return i >= A.length ? Integer.MAX_VALUE : (double) A[i];
    }

    public static void main(String[] args) {
        //    System.out.println(new Solution().findMedianSortedArrays(new int[]{1, 3}, new
        // int[]{2}));
        System.out.println(
                new Solution().findMedianSortedArrays(new int[] {3}, new int[] {-2, -1}));
    }
}

class Solution1 {
    public double findMedianSortedArrays(int[] A, int[] B) {
        if (A.length > B.length) {
            int t[] = B;
            B = A;
            A = t;
        }
        for (int i = -1, j = A.length; ; ) {
            int mA = (i + j) >> 1, mB = (A.length + B.length - 1) / 2 - 1 - mA;
            double mAl = min(A, mA), mAr = max(A, mA + 1), mBl = min(B, mB), mBr = max(B, mB + 1);
            if (mAl > mBr) {
                j = mA;
            } else if (mBl > mAr) {
                i = mA + 1;
            } else {
                if ((A.length + B.length) % 2 == 0) {
                    return (Math.max(mAl, mBl) + Math.min(mAr, mBr)) / 2.0;
                } else {
                    return Math.max(mAl, mBl);
                }
            }
        }
    }

    double min(int[] A, int i) {
        return i < 0 ? Integer.MIN_VALUE : A[i];
    }

    double max(int[] A, int i) {
        return i >= A.length ? Integer.MAX_VALUE : A[i];
    }
}
