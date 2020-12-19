package day5.最佳买卖股票时机含冷冻期;


/**
 * 给定一个整数数组，其中第i个元素代表了第i天的股票价格 。
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 *
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 *
 */

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int dpi0 = 0;
        int dpi1 = Integer.MIN_VALUE;
        int pre0 = 0;

        for (int i = 0; i < n; i++) {

            int temp = dpi0;
            dpi0 = Math.max(dpi0,dpi1 + prices[i]);
            dpi1 = Math.max(dpi1,pre0 - prices[i]);

            pre0 = temp;
        }
        return dpi0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,0,2};
        System.out.println(new Solution().maxProfit(nums));
    }
}