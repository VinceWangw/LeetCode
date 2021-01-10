package classes.动态规划.l45跳跃游戏2;


import java.util.Arrays;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 *
 */

//动态规划，超时
class Solution2 {
    public int jump(int[] nums) {

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, n);
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] + j >= i){
                    dp[i] = Math.min(1 + dp[j], dp[i]);
                }
            }
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().jump(new int[]{1,1,1,1}));
    }
}