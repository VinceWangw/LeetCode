package day17.打家劫舍II;

import java.sql.Struct;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈
 * ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。
 *
 * 示例 1：
 *
 * 输入：nums = [2,3,2] 输出：3 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。 示例 2：
 *
 * 输入：nums = [1,2,3,1] 输出：4 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。 偷窃到的最高金额 = 1 + 3 = 4 。
 *
 */

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1){
            return nums[0];
        }
        // 在不偷窃第一个房子的情况下（即 nums[1:] ），最大金额是 p1
        // 在不偷窃最后一个房子的情况下（即 nums[:n−1]），最大金额是 p2
        // 返回max(p1, p2)
        int pre1 = 0;
        int dpi1 = nums[1];
        for (int i = 2; i < n ; i++) {
            int temp = dpi1;
            dpi1 = Math.max(dpi1, pre1 + nums[i]);
            pre1 = temp;
        }

        int pre2 = 0;
        int dpi2 = nums[0];
        for (int i = 1; i < n - 1; i++) {
            int temp = dpi2;
            dpi2 = Math.max(dpi2, pre2 + nums[i]);
            pre2 = temp;
        }
        return Math.max(dpi1, dpi2);
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2, 3, 2};
        System.out.println(new Solution().rob(nums));
        System.out.println(new Solution().rob(new int[] {1, 2}));
        System.out.println(new Solution().rob(new int[] {}));
        System.out.println(new Solution().rob(new int[] {1}));
    }
}