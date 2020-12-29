package day02.整数反转;

/**
 * 类名: Solution
 * 描述: TODO
 * 姓名: wangf
 * 日期: 2020-12-15 10:06
 **/
class Solution {
    public int reverse(int x) {
        long sum = 0;
        while (x != 0) {
            sum = sum * 10 + x % 10;
            x /= 10;
            if (sum >= Integer.MAX_VALUE || sum <= Integer.MIN_VALUE) return 0;
        }

        return (int)sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverse(-2147483648));
    }
}
