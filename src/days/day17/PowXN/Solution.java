package days.day17.PowXN;


/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 */
class Solution {
    public double myPow(double x, int n) {
        if (x == 1) {
            return 1.0;
        }

        if (x == -1) {
            return n % 2 == 0 ? 1 : -1;
        }


        if (n == 0) {
            if (x == 0) {
                throw new IllegalArgumentException("error!");
            } else {
                return 1;
            }
        } else if (n > 0) {
            double res = 1.0;
            for (int i = n; i >= 1; i--) {
                res *= x;
                if (res > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
            }
            return res;
        } else {
            double res = 1.0;
            long nn = (long) n;
            for (long i = -nn; i >= 1; i--) {
                res *= x;
                if (res > Integer.MAX_VALUE) {
                    return 0;
                }
            }
            return 1 / res;
        }
    }

    /**
     * 位操作
     */
    public double myPow2(double x, int n) {
        if (x == 0.0f) {
            return 0.0d;
        }
        long b = n;
        double res = 1.0;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) {
                res *= x;
            }
            x = x * x;
            b = b >> 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().myPow(2.0000, 10));
        System.out.println(new Solution().myPow(2.1000, 3));
        System.out.println(new Solution().myPow(2.0000, -2));
        System.out.println(new Solution().myPow(1.0000, Integer.MAX_VALUE));
        System.out.println(new Solution().myPow(1.0000, Integer.MIN_VALUE));
        System.out.println(new Solution().myPow(0.100, Integer.MAX_VALUE));

    }
}