package days.day16.最长公共子序列;

/**
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 *
 * 一个字符串的子序列是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 *
 * 若这两个字符串没有公共子序列，则返回 0。
 *
 * 示例 1:
 *
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace"，它的长度为 3。
 * 示例 2:
 *
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc"，它的长度为 3。
 * 示例 3:
 *
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0。
 */
class Solution {

    /**
     * 1. 使用递归 - 超时
     */


    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        return findLonestCommonSubsequence(text1, text2, m-1, n-1);
    }
    private int findLonestCommonSubsequence(String text1, String text2, int end1, int end2){
        if (end1 == -1 || end2 == -1){
            return 0;
        }
        if (text1.charAt(end1) == text2.charAt(end2)){
            return 1 + findLonestCommonSubsequence(text1, text2, end1-1, end2-1);
        }else {
            return Math.max(findLonestCommonSubsequence(text1, text2, end1-1, end2),
                    findLonestCommonSubsequence(text1, text2, end1, end2-1));
        }
    }

    /**
     * 使用动归
     */
    public int longestCommonSubsequence2(String text1, String text2) {

        int m = text1.length();
        int n = text2.length();

        //dp[i][j] 表示 text[0..i] 和 text[0...j] 最长公共子序列长度
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (text1.charAt(i) == text2.charAt(j)){
                    dp[i+1][j+1] = 1 + dp[i][j];
                }else {
                    dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";

        String text3 = "pmjghexybyrgzczy";
        String text4 = "hafcdqbgncrcbihkd";

        System.out.println(new Solution().longestCommonSubsequence(text1, text2));
        System.out.println(new Solution().longestCommonSubsequence2(text1, text2));

        System.out.println("---------------------");
        System.out.println(new Solution().longestCommonSubsequence(text3, text4));
        System.out.println(new Solution().longestCommonSubsequence2(text3, text4));
    }
}