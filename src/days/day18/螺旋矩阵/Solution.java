package days.day18.螺旋矩阵;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 *
 * 输入: [ [ 1, 2, 3 ], [ 4, 5, 6 ], [ 7, 8, 9 ] ] 输出: [1,2,3,6,9,8,7,4,5] 示例 2:
 *
 * 输入: [ [1, 2, 3, 4], [5, 6, 7, 8], [9,10,11,12] ] 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 */

class Solution {

    int[][] direct = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    boolean[][] visited;
    int m, n;

    public List<Integer> spiralOrder(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        visited = new boolean[m][n];
        int i = 0, j = 0;
        int k = 0;
        do {
            while (inside(i, j) && !visited[i][j]) {
                res.add(matrix[i][j]);
                visited[i][j] = true;
                i += direct[k][0];
                j += direct[k][1];
            }
            i -= direct[k][0];
            j -= direct[k][1];
            k = (k+1) % 4;
            i += direct[k][0];
            j += direct[k][1];
        } while ( res.size() != m * n);
        return res;
    }

    private boolean inside(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(new Solution().spiralOrder(matrix));
        matrix = new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(new Solution().spiralOrder(matrix));
        matrix = new int[][] {{}};
        System.out.println(new Solution().spiralOrder(matrix));
    }
}