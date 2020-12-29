package day01.旋转图像;

class Solution {
    public void rotate(int[][] matrix) {
        //1. 转置矩阵
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //2. 倒序每一行

        for (int[] nums : matrix){
            reverse(nums);
        }
    }

    private void reverse(int[] nums) {

        int i = 0;
        int j = nums.length - 1;
        while (i <= j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i ++;
            j --;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {5, 1, 9,11},
                {2, 4, 8,10},
                {13,3, 6, 7},
                {15,14,12,16}
        };

        new Solution().print(matrix);
        System.out.print("\n");
        System.out.println("-----------------------");
        new Solution().rotate(matrix);
        new Solution().print(matrix);
    }

    private void print(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            printArr(matrix[i]);
        }
    }

    private void printArr(int[] nums){
        System.out.println();
        for (int num : nums){
            System.out.print(num + ".");
        }
    }
}