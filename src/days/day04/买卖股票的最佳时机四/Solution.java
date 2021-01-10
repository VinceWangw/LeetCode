package days.day04.买卖股票的最佳时机四;


/**
 * 给定一个整数数组prices ，它的第 i 个元素prices[i] 是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）
 *
 */

/**
 * 机制如我，一次通过
 *
 * @Author: Wangf
 */
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0)
            return 0;

        int[] dpi0 = new int[k+1];
        int[] dpi1 = new int[k+1];

        for (int i = 0; i <= k; i++) {
            dpi1[i] = Integer.MIN_VALUE;
        }
        for (int i = 0; i <= k; i++) {
            dpi0[i] = 0;
        }

        for (int price : prices) {
            for (int i = k; i >= 1; i--) {
                dpi0[i] = Math.max(dpi0[i], dpi1[i]+price);
                dpi1[i] = Math.max(dpi1[i], dpi0[i-1]-price);

            }
        }
        return dpi0[k];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,4,1};
        System.out.println(new Solution().maxProfit(2,nums));
    }
}