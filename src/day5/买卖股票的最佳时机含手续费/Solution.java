package day5.买卖股票的最佳时机含手续费;


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

}