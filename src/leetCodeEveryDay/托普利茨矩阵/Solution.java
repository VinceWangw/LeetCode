package leetCodeEveryDay.托普利茨矩阵;

class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < n; i++) {
            int curNum = matrix[0][i];

            int col = i;
            int row = 0;

            while (++ row < m && ++ col < n){
                if (matrix[row][col] != curNum){
                    return false;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            int curNum = matrix[i][0];
            int row = i;
            int col = 0;

            while (++ row < m && ++ col < n){
                if (matrix[row][col] != curNum){
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isToeplitzMatrix(new int[][]{{1,2,3,4},{5,1,2,3},{9,5,1,2}}));
        System.out.println(new Solution().isToeplitzMatrix(new int[][]{{1,2},{2,2}}));

    }
}