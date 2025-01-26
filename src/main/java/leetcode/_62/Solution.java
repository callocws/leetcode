package leetcode._62;

class Solution {
    public int uniquePaths(int m, int n) {
        return fac(m - 1, m + n - 2);
    }

    int fac(int u, int d) {
        u = Math.min(d - u, u);
        long divisor, divident, i;
        for (divisor = divident = i = 1; i <= u; i++, d--) {
            divisor *= i;
            divident *= d;
            if (divident % i == 0) {
                divident /= i;
                divisor /= i;
            }
        }
        return (int) (divident / divisor);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().uniquePaths(3, 3));
        System.out.println(new Solution().uniquePaths(10, 10)); // 48620
        System.out.println(new Solution().uniquePaths(23, 12)); // 193536720
        System.out.println(new Solution().uniquePaths(51, 9)); // 1916797311
        System.out.println(new Solution().uniquePaths(59, 5)); // 557845
    }
}

class Solution1 {
    public int uniquePaths(int m, int n) {
        return fac(m - 1, n - 1);
    }

    int fac(int a, int b) {
        long res = 1;
        if (a > b) {
            int t = a;
            a = b;
            b = t;
        }

        for (int i = 1; i <= a; i++, b++) {
            res = res * (b + 1) / i;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().uniquePaths(3, 3));
        System.out.println(new Solution1().uniquePaths(4, 4)); // 20
        System.out.println(new Solution1().uniquePaths(10, 10)); // 48620
        System.out.println(new Solution1().uniquePaths(23, 12)); // 193536720
        System.out.println(new Solution1().uniquePaths(51, 9)); // 1916797311
        System.out.println(new Solution1().uniquePaths(59, 5)); // 557845
    }
}

class Solution_2 {
    Integer dp[][];

    public int uniquePaths(int m, int n) {
        dp = new Integer[m][n];
        return uniquePaths(0, 0, m, n);
    }

    public int uniquePaths(int i, int j, int m, int n) {
        if (i == m || j == n) {
            return 0;
        }
        if (i == m - 1 && j == n - 1) {
            return 1;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        return dp[i][j] = uniquePaths(i + 1, j, m, n) + uniquePaths(i, j + 1, m, n);
    }

    public static void main(String[] args) {
        System.out.println(new Solution_2().uniquePaths(3, 3));
        System.out.println(new Solution_2().uniquePaths(4, 4)); // 20
        System.out.println(new Solution_2().uniquePaths(10, 10)); // 48620
        System.out.println(new Solution_2().uniquePaths(23, 12)); // 193536720
        System.out.println(new Solution_2().uniquePaths(51, 9)); // 1916797311
        System.out.println(new Solution_2().uniquePaths(59, 5)); // 557845
    }
}
