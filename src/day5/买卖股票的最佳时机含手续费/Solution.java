package day5.买卖股票的最佳时机含手续费;

/**
 * 类名: Solution
 * 描述: TODO
 * 姓名: wangf
 * 日期: 2020-12-18 14:31
 **/

/**
 *功能描述: TODO
 * 给定一个整数数组prices，其中第i个元素代表了第i天的股票价格 ；非负整数fee 代表了交易股票的手续费用。
 *
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 *
 * 返回获得利润的最大值。
 * 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出: 8
 * 解释: 能够达到的最大利润:
 * 在此处买入prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润:((8 - 1) - 2) + ((9 - 4) - 2) = 8
 * @return
 * */

class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;

        int dpi0 = 0;
        int dpi1 = -prices[0];

        for (int price : prices){
            dpi0 = Math.max(dpi0,dpi1 + price - fee);
            dpi1 = Math.max(dpi1,dpi0 - price);
        }

        return dpi0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 2, 8, 4, 9};
        System.out.println(new Solution().maxProfit(nums,2));
    }
}