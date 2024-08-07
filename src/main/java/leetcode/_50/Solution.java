package leetcode._50;

import java.util.HashMap;

class Solution {
    public double myPow(double x, int n) {
        if(n == 0) {
            return 1;
        }
        if(n < 0) {
            x = 1 / x;
            n *= -1;
        }
        double r = 1;
        for(int i = 0; i < n; i++) {
            r *= x;
        }
        return r;
    }
}
class Solution1 {
    HashMap<Integer, Double> m = new HashMap();
    public double myPow(double x, int n) {
        if(n == 0) {
            return 1;
        }
        if(n < 0) {
            if (n == Integer.MIN_VALUE && Math.abs(x) > 1) {
                return 0;
            }
            x = 1 / x;
            n *= -1;
        }
        if(n == 1) {
            return x;
        }
        Double v = m.get(n);
        if(v != null) {
            return v;
        }
        Double r = (n % 2 == 0 ? 1 : x) * myPow(x, n / 2) * myPow(x, n / 2);
        m.put(n, r);
        return r;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().myPow(2.00000, -2147483648));
    }
}

class Solution2 {
    public double myPow(double x, long n) {
        if(n == 0) {
            return 1;
        }
        if(n < 0) {
            x = 1 / x;
            n *= -1;
        }
        double v = myPow(x, n / 2);
        return (n % 2 == 0 ? 1 : x) * v * v;
    }
}