package day01.有效的数独;

/**
 * 类名: Solution
 * 描述: TODO
 * 姓名: wangf
 * 日期: 2020-12-14 17:39
 **/
class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] columns = new boolean[9][9];
        boolean[][] block = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.'){
                    int num = board[i][j] - '1';
                    int blockIndex = i/3 * 3 + j/3;
                    if (rows[i][num] || columns[j][num] || block[blockIndex][num]){
                        return false;
                    }else {
                        rows[i][num] = true;
                        columns[j][num] = true;
                        block[blockIndex][num] = true;
                    }
                }
            }
        }
        return true;
    }
}