package leetcode._62;

class Solution {
    public int uniquePaths(int m, int n) {
        return fac(m - 1, m + n - 2);
    }

    int fac(int u, int d) {
        long a, b, i;
        for(a = b = i = 1; i <= u;i++, d--) {
            a *= i;
            b *= d;
            if(b % i == 0) {
                b /= i;
                a /= i;
            }
        }
        return (int) (b / a);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().uniquePaths(3, 3));
        System.out.println(new Solution().uniquePaths(10, 10)); //48620
        System.out.println(new Solution().uniquePaths(23,12)); // 193536720
        System.out.println(new Solution().uniquePaths(51, 9)); //1916797311
    }
}