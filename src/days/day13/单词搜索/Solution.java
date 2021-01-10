package days.day13.单词搜索;


/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，
 * 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 */
class Solution {

    int[][] direct = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
    boolean[][] used;
    int m, n;

    public boolean exist(char[][] board, String word) {

        m = board.length;
        n = board[0].length;
        used = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (find(board, word, i, j, 0)){
                    return true;
                }
            }
        }
       return false;
    }

    private boolean find(char[][] board, String word, int startX, int startY, int index){

        if (index == word.length() - 1){
            return board[startX][startY] == word.charAt(index);
        }

        if (board[startX][startY] == word.charAt(index)) {
            used[startX][startY] = true;
            for (int i = 0; i < 4; i++) {
                int newX = startX + direct[i][0];
                int newY = startY + direct[i][1];
                System.out.println("当前位置：" + "[" + startX + "," + startY +"]" + ", "+  "当前字母：" +
                                word.charAt(index) + "\n" + "目标位置" + "[" + newX + "," + newY +  "]" + ", "
                                +"查找：" +"第" + (i+1) + "个字母：" + word.charAt(index+1));
                System.out.println("-------------------------------");
                if (inArea(newX, newY) && !used[newX][newY] &&
                        find(board, word, newX, newY, index + 1)) {
                    return true;
                }
            }
            used[startX][startY] = false;
        }
        return false;
    }

    private boolean inArea(int X, int Y){
        return X < m && X >= 0 && Y < n && Y>= 0;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]
                    {
                        {'A','B','C','E'},
                        {'S','F','C','S'},
                        {'A','D','E','E'}
                    };

        System.out.println(new Solution().exist(board,"ABCCED"));

    }
}