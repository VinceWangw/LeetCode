package days.day26.目标和;


/**
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。
 * 对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 *
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 *
 *
 * 输入：nums: [1, 1, 1, 1, 1], S: 3
 * 输出：5
 *
 */
class Solution {
    public int findTargetSumWays(int[] nums, int S) {

        int n = nums.length;
        int[][] dp = new int[n+1][S+1000];
        dp[1][nums[0]] = 1;

        for (int i = 1; i < n + 1; i++) {
            dp[i][S] = dp[i-1][S-nums[i-1]] + dp[i-1][S+nums[S]];
        }

        return dp[n][S];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findTargetSumWays(new int[]{1,1,1,1,1}, 3));
    }
}