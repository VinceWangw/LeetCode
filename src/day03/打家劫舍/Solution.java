package day03.打家劫舍;

/**
 * 类名: Solution
 * 描述: TODO
 * 姓名: wangf
 * 日期: 2020-12-16 15:38
 **/

/**
 *功能描述: TODO
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * 示例 1：
 *
 * 输入：[1,2,3,1]
 * 输出：4
 *
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *     偷窃到的最高金额 = 1 + 3 = 4
 * @return 
 * */
 
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        //dp[i]表示第i天能取得的最高金额
        //dp[i] = max(dp[i-1], dp[i-2] + nums[i]
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2] + nums[i-1]);
        }

        return dp[n];
    }

    //优化空间O(n)->O(1)
    public int rob2(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int pre1 = 0;
        int pre2 = nums[0];

        for (int i = 2; i <= n; i++) {
            int temp = pre2;
            pre2 = Math.max(pre2, pre1 + nums[i-1]);
            pre1 =temp;
        }

        return pre2;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1};
        System.out.println(new Solution().rob2(nums));
    }
}