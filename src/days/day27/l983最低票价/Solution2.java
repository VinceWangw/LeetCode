package days.day27.l983最低票价;

import java.util.Arrays;

class Solution2 {
    public int mincostTickets(int[] days, int[] costs) {

        int n = days[days.length-1];
        int[] dp = new int[n];

        int dp1 = costs[0];

        int dp7 = costs[1];
        int day7 = days[0];

        int dp30 = costs[2];
        int day30 = days[0];

        dp[0] = dp1;

        for (int i = 1; i < n; i++) {
            int temp7 = dp7;
            int temp30 = dp30;
            if (days[i] - day7 >= 7) {
                dp7 = dp7 + costs[1];
                day7 = i;
            }
            if (days[i] - day30 >= 30){
                dp30 = dp30 + costs[2];
                day30 = i;
            }
            dp1 = Math.min(dp1 + costs[0], Math.min(temp7 + costs[0], temp30 + costs[0]));

            dp[i] = Math.min(Math.min(dp1, dp7), dp30);
        }
        System.out.println(Arrays.toString(dp));
        return dp[n-1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().mincostTickets(
                new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31},
                new int[]{2, 7, 15}
        ));
        System.out.println(new Solution2().mincostTickets(
                new int[]{1, 4, 6, 7, 8, 20},
                new int[]{2, 7, 15}
        ));

        System.out.println(new Solution2().mincostTickets(
                new int[]{1, 4, 6, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 20, 21, 22, 23, 27, 28},
                new int[]{3, 13, 45}
        ));
    }
}