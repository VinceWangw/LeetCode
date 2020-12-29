package day15.买卖股票的最佳时机IV;


import java.util.Arrays;

/**
 * 功能描述: TODO
 * 188. 买卖股票的最佳时机 IV
 * 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）
 * @return
 * */

class Solution {
    public int maxProfit(int k, int[] prices) {

        int[] dpi0 = new int[k+1];
        int[] dpi1 = new int[k+1];

        Arrays.fill(dpi0, 0);
        Arrays.fill(dpi1, Integer.MIN_VALUE);

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
        System.out.println(new Solution().maxProfit(2, nums));
    }
}
