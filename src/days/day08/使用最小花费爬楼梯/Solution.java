package days.day08.使用最小花费爬楼梯;

/**
 *功能描述: TODO
 * 数组的每个索引作为一个阶梯，第i个阶梯对应着一个非负数的体力花费值cost[i](索引从0开始)。
 *
 * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 *
 * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 *
 * 示例1:
 *
 * 输入: cost = [10, 15, 20]
 * 输出: 15
 * 解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
 *
 * 示例 2:
 *
 * 输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * 输出: 6
 * 解释: 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。
 *
 * */

class Solution {
    public int minCostClimbingStairs(int[] cost) {

        int n = cost.length;
        int pre = 0;
        int dpi = cost[0];

        for (int i = 2; i <= n; i ++){
            int temp = dpi;
            dpi = Math.min(dpi, pre) + cost[i-1];
            pre = temp;
        }
        return Math.min(pre, dpi);
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int[] nums = new int[]{10,15,20};
        System.out.println(new Solution().minCostClimbingStairs(nums1));
        System.out.println(new Solution().minCostClimbingStairs(nums));
    }
}