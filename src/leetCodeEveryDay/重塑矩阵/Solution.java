package leetCodeEveryDay.重塑矩阵;

import java.util.Arrays;

class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums == null || nums.length == 0){
            return null;
        }
        int m = nums.length;
        int n = nums[0].length;

        if (m * n != r * c){
            return nums;
        }
        int[][] res = new int[r][c];
        for (int x = 0; x < m * n; ++x) {
            res[x / c][x % c] = nums[x / n][x % n];
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] nums = {{1,2,3,4}};
        int[][] res = new Solution().matrixReshape(nums, 1, 4);
        System.out.println(Arrays.deepToString(res));
    }
}