package day20.完全平方数;


import java.sql.SQLOutput;
import java.util.Arrays;

/**
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。
 * 你需要让组成和的完全平方数的个数最少。
 *
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 *
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 *
 */
class Solution {
    public int numSquares(int n) {

        int[] dp = new int[n+1];
        Arrays.fill(dp, 2, n+ 1, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        int max_square_index = (int)Math.sqrt(n) + 1;
        int square_nums[] = new int[max_square_index];
        for (int i = 1; i < max_square_index; ++i) {
            square_nums[i] = i * i;
        }
        for (int i = 2; i <= n ; i++) {
            for (int j = 1; j <= max_square_index; j++) {
                if (i - j * j < n + 1 && i - j * j >= 0){
                    dp[i] = Math.min(1 + dp[i-square_nums[j]], dp[i]);
                }else{
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numSquares(12));
        System.out.println(new Solution().numSquares(13));
        System.out.println(new Solution().numSquares(2));
        System.out.println(new Solution().numSquares(11));
    }
}