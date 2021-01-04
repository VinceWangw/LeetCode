package day22.最长回文子串;

/**
 * 类名: Solution1 描述: TODO 姓名: 悟天 日期: 2021-01-04 13:12
 **/
public class Solution1 {

    // dp[i][j] = (s[i] == s[j]) and (j - i < 3 or dp[i + 1][j - 1])

    public String longestPalindrome(String s) {

        char[] str = s.toCharArray();
        int n = str.length;

        // dp[i][j] : str[i..j]是否为回文
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        int l = 0, r = 0;
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                // if (str[j] == str[i] ){
                // if (j - i < 3){
                // dp[i][j] = true;
                // }else{
                // dp[i][j] = dp[i+1][j-1];
                // }
                // if (dp[i][j] && (j - i > r - l)){
                // l = i;
                // r = j;
                // }
                // }else {
                // dp[i][j] = false;
                // }
                dp[i][j] = str[i] == str[j] && (j - i < 3 || dp[i + 1][j - 1]);
                if (dp[i][j] && (j - i > r - l)) {
                    l = i;
                    r = j;
                }
            }
        }
        return s.substring(l, r + 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().longestPalindrome("aabaaa"));
        System.out.println(new Solution1().longestPalindrome("cbbd"));
    }
}
