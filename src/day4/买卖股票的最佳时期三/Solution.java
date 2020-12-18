package day4.买卖股票的最佳时期三;

/**
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成两笔交易。
 *
 * 注意:你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 示例1:
 *
 * 输入: [3,3,5,0,0,3,1,4]
 * 输出: 6
 * 解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 *     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 *
 */
class Solution {
    public int maxProfit(int[] prices) {

        int n = prices.length;
        if (n == 0)
            return 0;
        int dpi20 = 0;
        int dpi21 = Integer.MIN_VALUE;
        int dpi10 = 0;
        int dpi11 = Integer.MIN_VALUE;

        for (int price : prices) {
            dpi10 = Math.max(dpi10,dpi11 + price);
            dpi11 = Math.max(dpi11, - price);
            dpi20 = Math.max(dpi20,dpi21 + price);
            dpi21 = Math.max(dpi21,dpi10 - price);

        }
        return dpi20;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7,6,4,3,1};
        System.out.println(new Solution().maxProfit(nums));
    }
}