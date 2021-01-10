package days.day27.l647回文子串;

import java.util.Arrays;

//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
//
//
//
// 示例 1：
//
// 输入："abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
//
//
// 示例 2：
//
// 输入："aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
//
// "aaaaa"
//
// 提示：
//
//
// 输入的字符串长度不会超过 1000 。
//
class Solution {
    public int countSubstrings(String s) {
        int n = s.length();

        char[] str = s.toCharArray();
        //dp[i] : 以s[i] 为中心的回文数
        //包括： s[i..i+1]
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int count = 0;
//        for (int i = 0; i < n; i++) {
//            int l = i, r = i;
//
//            if (r + 1 < n && str[l] == str[r + 1]) {
//                dp[i]++;
//                r++;
//                while (l - 1 >= 0 && r + 1 < n) {
//                    if (str[--l] == str[++r])
//                        dp[i] += 1;
//                    else
//                        break;
//                }
//
//            }
//
//            l = i;
//            r = i;
//            while (l - 1 >= 0 && r + 1 < n) {
//                if (str[--l] == str[++r])
//                    dp[i] += 1;
//                else
//                    break;
//            }
//
//
//            count += dp[i];
//        }
        //遍历回文中心点
        for (int i = 0; i < n; i++) {
            //j=0,中心是一个点，j=1,中心是两个点
            for (int j = 0; j <= 1; j++)
            {
                int l = i;
                int r = i + j;
                while (l >= 0 && r < n && str[l--] == str[r++])
                    count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        System.out.println(new Solution().countSubstrings("aaaaa"));
    }
}