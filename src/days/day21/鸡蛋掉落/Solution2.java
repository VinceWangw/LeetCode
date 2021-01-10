package days.day21.鸡蛋掉落;

class Solution2 {
    public int superEggDrop(int K, int N) {

        /*
             1. 在第x层扔，最少次数为 max( dp[k-1][x-1], dp[k][n-x] ) + 1
             2. 在 1～N 层中寻找上式最小值
             3. dp[i][j] : i个🥚，j层楼 最少次数
                dp[K][N] = for x in [1 ~ N]  min (1 + max( dp[k-1][x-1], dp[k][n-x] ) )
         */
        int[][] dp = new int[K + 1][N + 1];
        for (int i = 0; i < K + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < N + 1; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i < N + 1; i++) {
            dp[1][i] = i;
        }
        for (int i = 0; i < K + 1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < K + 1; i++) {
            dp[i][1] = 1;
        }

        for (int i = 2; i < K + 1; i++) {
            for (int j = 2; j < N + 1; j++) {
                //  for (int k = 1; k < j + 1; k++) {
                //      dp[i][j] = Math.min(1 + Math.max(dp[i - 1][k - 1], dp[i][j - k]), dp[i][j]);
                //  }
                //使查找随着 k 变化 max(dp[i - 1][k - 1], dp[i][j - k])的最小值
                //随着 k 的变大，dp[i - 1][k - 1] 单调增加， dp[i][j - k] 单调减少
                //交点出即为结果的最小值
                //用二分搜索 查找最小值
                //也就是找到使得 dp[j - k][i] <= dp[k - 1][i - 1] 最大的那个 k 值即可。
                // 这里使用二分查找算法。关键在于 dp[i - k][j] > dp[k - i][j - 1] 的时候，
                // k 一定不是我们要找的，根据这一点写出二分的代码。
                // k in [1, j], 二分搜索

                int left = 1, right = j;
                while (left <= right){
                    int mid = left + (right - left) / 2;
                    // 上升
                    int breakCount = dp[i - 1][mid - 1];
                    // 下降
                    int notBreakCount = dp[i][j - mid];

                    if (breakCount > notBreakCount){
                        // 严格大于的时候一定不是解，此时 mid 一定不是解
                        // 下一轮搜索区间是 [left, mid - 1]
                        right = mid - 1;
                    }else if (breakCount < notBreakCount){
                        // 这个区间一定是上一个区间的反面，即 [mid, right]
                        // 注意这个时候取中间数要上取整，int mid = left + (right - left + 1) / 2;
                        left = mid + 1;
                    }else {
                        left = mid;
                        break;
                    }
                }

                dp[i][j] = Math.min(1 + Math.max(dp[i - 1][left - 1], dp[i][j - left]), dp[i][j]);
            }
        }
        return dp[K][N];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().superEggDrop(2, 6));
    }
}