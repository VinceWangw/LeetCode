package days.day04.买卖股票的最佳时期二;


/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）
 *
 */
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0)
            return 0;

        int dp[][] = new int[n+1][2];
        dp[0][0] = 0;
        dp[0][1] = - prices[0];

        for (int i = 1; i < prices.length+1; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i-1]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i-1]);
        }
        return dp[n][0];
    }

    public static void main(String[] args) {
        int prices[] = new int[]{7,1,5,3,6,4};
        System.out.println(new Solution().maxProfit(prices));
    }
}