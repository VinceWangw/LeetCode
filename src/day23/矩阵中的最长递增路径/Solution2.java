package day23.矩阵中的最长递增路径;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 类名: Solution2
 * 描述: TODO
 * 姓名: 悟天
 * 日期: 2021-01-05 14:22
 **/
class Solution2 {
    public int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int m, n;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        m = matrix.length;
        n = matrix[0].length;
        int[][] outdegrees = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int[] dir : dirs) {
                    int newX = i + dir[0], newY = j + dir[1];
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n && matrix[newX][newY] > matrix[i][j]) {
                        ++outdegrees[i][j];
                    }
                }
            }
        }
        Queue<int[]> queue = new LinkedList<int[]>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (outdegrees[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int ans = 0;
        while (!queue.isEmpty()) {
            ++ans;
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int[] cell = queue.poll();
                int row = cell[0], column = cell[1];
                for (int[] dir : dirs) {
                    int newRow = row + dir[0], newColumn = column + dir[1];
                    if (newRow >= 0 && newRow < m && newColumn >= 0 && newColumn < n && matrix[newRow][newColumn] < matrix[row][column]) {
                        --outdegrees[newRow][newColumn];
                        if (outdegrees[newRow][newColumn] == 0) {
                            queue.offer(new int[]{newRow, newColumn});
                        }
                    }
                }
            }
        }
        return ans;
    }
}

