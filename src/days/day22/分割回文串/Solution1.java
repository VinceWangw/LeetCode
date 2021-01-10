package days.day22.分割回文串;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 输入: "aab" 输出: [ ["aa","b"], ["a","a","b"] ]
 */

public class Solution1 {

    int len;
    List<List<String>> res;
    boolean[][] dp;

    public List<List<String>> partition(String s) {
        len = s.length();
        res = new ArrayList<>();
        dp = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int j = 0; j < len; j++) {
            for (int i = 0; i < j; i++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1] );
            }
        }

        Deque<String> stack = new ArrayDeque<>();
        findPalindrome(s, 0, stack);
        return res;
    }

    private void findPalindrome(String s, int beginIndex, Deque<String> stack) {
        if (beginIndex == len){
            res.add(new ArrayList<>(stack));
            return;
        }

        for (int i = beginIndex; i < len; i++) {

            if (!dp[beginIndex][i]){
                continue;
            }

            stack.addLast(s.substring(beginIndex, i + 1));
            findPalindrome(s, i + 1, stack);
            stack.removeLast();
        }
    }


    public static void main(String[] args) {
        System.out.println(new Solution().partition("aaba"));
    }
}
