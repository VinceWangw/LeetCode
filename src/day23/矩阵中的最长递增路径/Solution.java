package day23.矩阵中的最长递增路径;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给定一个整数矩阵，找出最长递增路径的长度。 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
 *
 * 输入: nums = [ [9,9,4], [6,6,8], [2,1,1] ] 输出: 4 解释: 最长递增路径为 [1, 2, 6, 9]。
 *
 * 输入: nums = [ [3,4,5], [3,2,6], [2,2,1] ] 输出: 4 解释: 最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
 */

class Solution {

    /**
     * Node 类用于实现对每个位置的值排序及位置记录
     * */
    class Node {
        int val;
        int i;
        int j;

        public Node(int val, int i, int j) {
            this.val = val;
            this.i = i;
            this.j = j;
        }
    }

    // 4个方向
    int[][] direction = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    int m, n;

    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        if (m == 0)
            return 0;
        n = matrix[0].length;

        // 使用堆，按照每个位置值的大小排序
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = 1;
                // 将所有位置添加到堆
                pq.offer(new Node(matrix[i][j], i, j));
            }
        }

        //记录结果，最小为1（不存在为0时已排除）
        int max = 1;

        //开始按照从小到大顺序更新值
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int i = node.i, j = node.j;
            for (int k = 0; k < 4; k++) {
                int newX = i + direction[k][0];
                int newY = j + direction[k][1];

                if (inArea(newX, newY) && matrix[i][j] > matrix[newX][newY]) {
                    dp[i][j] = Math.max(1 + dp[newX][newY], dp[i][j]);
                    max = Math.max(max, dp[i][j]);
                }

            }
        }
        return max;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{7, 8, 9}, {9, 7, 6}, {7, 2, 3}};

        System.out.println(new Solution().longestIncreasingPath(matrix));
    }
}