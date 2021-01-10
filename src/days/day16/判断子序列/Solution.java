package days.day16.判断子序列;


/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 进阶：
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 */
class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()){
            if (s.charAt(i) == t.charAt(j)){
                i ++;
                j ++;
            }else {
                j ++;
            }
        }
        if (i == s.length()){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 使用动态规划
     */
    public boolean isSubsequence2(String s, String t) {

        int m = s.length();
        int n = t.length();

        if (m == 0){ return true; }

        boolean[][] dp = new boolean[m+1][n+1];

        for (int j = 0; j <= n; j++) {
            dp[0][j] = true;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (s.charAt(i) == t.charAt(j)){
                    dp[i+1][j+1] = dp[i][j];
                }else {
                    dp[i+1][j+1] = dp[i+1][j];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String s = "acd";
        String t = "abcde";
        System.out.println(new Solution().isSubsequence2(s, t));

        s = "twn";
        t = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxtxxxxxxxxxxxxxxxxxxxxwxxxxxxxxxxxxxxxxxxxxxxxxxn";
        System.out.println(new Solution().isSubsequence2(s, t));
    }
}