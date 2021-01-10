package days.day18.x的平方根;

/**
 * 实现 int sqrt(int x)函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * */
 
class Solution {
    public int mySqrt(int x) {

        if (x == 1){
            return 1;
        }
        return getSqrt(x, 0, x);
    }

    private int getSqrt(long x, long left, long right){
        if (right - left <= 1){
            return (int)left;
        }

        long mid = left + (right - left) / 2;
        if (mid * mid == x){
            return (int)mid;
        }else if (mid * mid > x){
            return getSqrt(x, left, mid);
        }else {
            return getSqrt(x, mid, right);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 101; i++) {
            System.out.println(i + " 的平方根为： " + new Solution().mySqrt(i));
        }
        System.out.println(new Solution().mySqrt(2147395599));
        System.out.println(Integer.MAX_VALUE);
    }
}