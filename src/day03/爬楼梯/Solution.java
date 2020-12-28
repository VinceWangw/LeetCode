package day03.爬楼梯;

/**
 * 类名: Solution
 * 描述: TODO
 * 姓名: wangf
 * 日期: 2020-12-16 13:51
 **/

/**
 *功能描述: TODO
 * 假设你正在爬楼梯。需要 n阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 *
 * @return
 * */

class Solution {
    //f(x) = f(x-1) + f(x-2),类似于斐波那契数列
    //空间复杂度O(N)
    public int climbStairs(int n) {

        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    //空间复杂度可优化至O(1)
    public int climbStairs2(int n) {

        int p = 0;
        int q = 1;
        int res = 0;
        for (int i = 0; i <= n; i++) {
            int temp = p + q;
            p = q;
            q = res;
            res = p + q;
        }
        return res;
    }

    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            System.out.println(new Solution().climbStairs(i) + " - "
                                +new Solution().climbStairs2(i));
        }
    }
}