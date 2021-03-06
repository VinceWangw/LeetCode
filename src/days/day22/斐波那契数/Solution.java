package days.day22.斐波那契数;

/**
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。
 * 该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 *
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给你 n ，请计算 F(n) 。
 *
 * */

class Solution {
    public int fib(int n) {
        int a = 0;
        if (n == 0)
            return a;
        int b = 1;

        for (int i = 2; i <= n; i++) {
            int temp = b;
            b = a + b;
            a = temp;
        }

        return b % 1000000007;
    }

    public static void main(String[] args) {
//        for (int i = 0; i < 100; i++) {
//            System.out.print(new Solution().fib(i) + " ");
//        }
        System.out.println(new Solution().fib(45));

    }
}