package days.day11.跳跃游戏;

/**
 *功能描述: TODO
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 *
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvb8zs/
 *
 * @return
 * */


class Solution {
    //1. 动态规划
    public boolean canJump(int[] nums) {
        int n = nums.length;
        //dp[i] 表示能否到达当前位置
        boolean[] dp = new boolean[n];
        dp[0] = true;

        for (int i = 1; i < n; i ++){
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && nums[j] >= i - j){
                    dp[i] = true;
                }
            }
        }
        return dp[n-1];
    }
    //2. 贪心算法，只要能到达i位置，那么一定能到达[0,i)
    //计算能到达的最远距离是否大于nums.length;
    public boolean canJump2(int[] nums) {

        int n = nums.length;

        //k : 当前位置能跳到的最远距离
        int k = 0;
        for (int i = 0; i < n; i++)
        {
            if (i > k) return false;
            k = Math.max(k, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,0,4};
        int[] nums1 = new int[]{2,3,1,1,4};
        int[] nums2 = new int[]{0,2,3};
        System.out.println(new Solution().canJump2(nums));
        System.out.println(new Solution().canJump2(nums1));
        System.out.println(new Solution().canJump2(nums2));
    }
}
