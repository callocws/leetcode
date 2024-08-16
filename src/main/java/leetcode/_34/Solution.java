package leetcode._34;



class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = search(nums, 0, nums.length, target), r = search(nums, 0, nums.length, target + 1) - 1;
        if(l == nums.length || nums[l] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{l, r};
    }

    int search(int[] A, int i, int j, int target) {
        for(; i < j; ) {
            int m = (i + j) >> 1;
            if(A[m] < target) {
                i = m + 1;
            } else {
                j = m;
            }
        }
        return i;
    }
}



class Solution2 {
    public int[] searchRange(int[] nums, int target) {
        int l = search(nums, 0, nums.length, target), r = search1(nums, 0, nums.length, target);
        if(l == nums.length || nums[l] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{l, r};
    }

    int search(int[] A, int i, int j, int target) {
        if(i >= j) {
            return i;
        }
        int m = (i + j) >> 1;
        if(A[m] == target) {
            return search(A, i, m, target);
        } else if(A[m] < target) {
            return search(A, m + 1, j, target);
        } else {
            return search(A, i, m, target);
        }
    }

    int search1(int[] A, int i, int j, int target) {
        if(i >= j) {
            return i - 1;
        }
        int m = (i + j) >> 1;
        if(A[m] == target) {
            return search1(A, m + 1, j, target);
        } else if(A[m] < target) {
            return search1(A, m + 1, j, target);
        } else {
            return search1(A, i, m, target);
        }
    }
}