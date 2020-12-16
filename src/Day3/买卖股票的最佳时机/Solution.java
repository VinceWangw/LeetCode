package Day3.买卖股票的最佳时机;

/**
 * 类名: Solution
 * 描述: TODO
 * 姓名: wangf
 * 日期: 2020-12-16 14:10
 **/

/**
 *功能描述: TODO
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * 注意：你不能在买入股票前卖出股票。
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * */
 
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0 || n == 1) return 0;
        int dp[] = new int[n]; //dp[i]表示前i天的最大利润
        dp[0] = 0;
        int min = prices[0];
        for (int i = 1; i < n; i++) {
            min = Math.min(min,prices[i]);
            dp[i] = Math.max(dp[i-1],prices[i]-min);
        }

        return dp[n-1];
    }

    //优化空间O(n)->O(1)
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        if (n == 0 || n == 1) return 0;

        int min = Integer.MAX_VALUE;
        int max = -1;
        for (int i = 0; i < n; i++) {
            min = Math.min(min,prices[i]);
            max = Math.max(max,prices[i]-min);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2};
        System.out.println(new Solution().maxProfit2(nums));
    }
}