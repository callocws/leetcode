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
//    System.out.println(new Solution().findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
    System.out.println(new Solution().findMedianSortedArrays(new int[]{3}, new int[]{-2, -1}));
  }
}