package day20.戳气球;


import java.util.Arrays;

/**
 * 有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 * <p>
 * 现在要求你戳破所有的气球。如果你戳破气球 i ，就可以获得 nums[left] * nums[i] * nums[right] 个硬币。
 * 这里的left和right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。
 * <p>
 * 求所能获得硬币的最大数量。
 * <p>
 * 说明:
 * <p>
 * 你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
 * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * 示例:
 * <p>
 * 输入: [3,1,5,8]
 * 输出: 167
 * 解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 * coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 */
class Solution {
    public int maxCoins(int[] nums) {

        int n = nums.length;

        int[][] dp = new int[n + 2][n + 2];

        int[] numsCopy = new int[n + 2];
        System.arraycopy(nums, 0, numsCopy, 1, n);
        numsCopy[n + 1] = 1;
        numsCopy[0] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j <= n + 1; j++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(
                            dp[i][k] + numsCopy[i] * numsCopy[j] * numsCopy[k] + dp[k + 1][j], dp[k][j]);
                }
            }
        }
        return dp[0][n + 1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 5, 8};
        System.out.println(
                new Solution().maxCoins(nums)
        );
    }
}