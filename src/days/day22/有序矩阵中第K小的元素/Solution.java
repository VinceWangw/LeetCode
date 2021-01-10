package days.day22.有序矩阵中第K小的元素;

/**
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 * <p>
 * matrix = [
 * [ 1,  5,  9],
 * [10, 11, 13],
 * [12, 14, 15]
 * ],
 * k = 8,
 * <p>
 * 返回 13。
 * 【1，2】
 * 【3，3】 2
 * [1,2]
 * [1,3] 2
 */

//TODO:不会
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int row = (k - 1) % n;
        int col = (k - 1) / n;

        return Math.min(matrix[col][row],matrix[row][col]);
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        System.out.println(new Solution().kthSmallest(matrix, 8));
    }
}