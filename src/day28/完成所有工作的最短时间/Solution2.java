package day28.完成所有工作的最短时间;

public class Solution2 {

    public int minimumTimeRequired(int[] jobs, int k) {
        return dyn(jobs, k, jobs.length);
    }

    private static int dyn(int[] arr, int n, int m) {
        int[][] dp = new int[m][n];
        int[] sum = new int[arr.length];
        //计算sum数组
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                sum[i] = arr[i];
            } else {
                sum[i] = sum[i - 1] + arr[i];
            }
        }
        //初始化basecase
        for (int i = 0; i < n; i++) {
            dp[0][i] = sum[i];
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = arr[0];
        }
        //动态规划计算
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int best = Integer.MAX_VALUE;
                //进行选择
                for (int k = 0; k <= j; k++) {
                    best = Math.min(best, Math.max(dp[i - 1][k], sum[j] - sum[k]));
                }
                dp[i][j] = best;
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().minimumTimeRequired(new int[]{1,2,4,7,8}, 2));
        System.out.println(new Solution2().minimumTimeRequired(new int[]{12,13,14,17,25}, 3));
    }
}
