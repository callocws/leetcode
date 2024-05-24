package leetcode._238;

// 238. Product of Array Except Self
class Solution {

  public int[] productExceptSelf(int[] nums) {
    int n = nums.length, A[] = new int[n], B[] = new int[n];
    for (int i = 0, j = n - 1; i < n; i++, j--) {
      if (i == 0) {
        A[i] = nums[i];
        B[j] = nums[j];
      } else {
        A[i] = nums[i] * A[i - 1];
        B[j] = nums[j] * B[j + 1];
      }
    }
    for (int i = 0; i < n; i++) {
      int k = i == 0 ? 1 : A[i - 1], t = i == n - 1 ? 1 : B[i + 1];
      nums[i] = k * t;
    }
    return nums;
  }
  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4};
    System.out.println(new Solution().productExceptSelf(nums));
  }
}

class Solution1 {
  public int[] productExceptSelf(int[] nums) {
    int n = nums.length, A[] = new int[n];
    A[0] = 1;
    for(int i = 1; i < n; i++) {
      A[i] = nums[i - 1] * A[i - 1];
    }

    for(int i = n - 2; i >= 0; i--) {
      A[i] = A[i] * nums[i + 1];
      nums[i] *= nums[i + 1];
    }

    return A;
  }
}