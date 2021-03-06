package days.day21.鸡蛋掉落;


/**
 * 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N 共有 N 层楼的建筑。
 * 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
 * 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
 * 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。
 * 你的目标是确切地知道 F 的值是多少。
 * 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
 * 示例 1：
 * 输入：K = 1, N = 2
 * 输出：2
 * 解释：
 * 鸡蛋从 1 楼掉落。如果它碎了，我们肯定知道 F = 0 。
 * 否则，鸡蛋从 2 楼掉落。如果它碎了，我们肯定知道 F = 1 。
 * 如果它没碎，那么我们肯定知道 F = 2 。
 * 因此，在最坏的情况下我们需要移动 2 次以确定 F 是多少。
 * 示例 2：
 * <p>
 * 输入：K = 2, N = 6
 * 输出：3
 * 示例 3：
 * <p>
 * 输入：K = 3, N = 14
 * 输出：4
 */
class Solution {
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
                for (int k = 1; k < j + 1; k++) {
                    dp[i][j] = Math.min(1 + Math.max(dp[i - 1][k - 1], dp[i][j - k]), dp[i][j]);
                }
            }
        }
        return dp[K][N];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().superEggDrop(2, 6));
    }
}