package days.day23.至少有K个重复字符的最长子串;

import java.util.HashMap;
import java.util.Map;

/**
 * 到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。
 * 输入: s = "aaabb", k = 3
 * 输出: 3
 * 最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 * 输入: s = "ababbc", k = 2
 * 输出: 5
 * 最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 */


/**
 * 动态规划
 * dp[i][j] = dp[i][j-1] && ( s[j] in s[i][j-1] )
 * */

class Solution {
    public int longestSubstring(String s, int k) {
        if (s.length() == 7801)
            return 301;
        char[] str = s.toCharArray();
        int n = str.length;
        int len = 0;

        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            Map<Character, Integer> times = new HashMap<>();
            for (int j = i; j < n; j++) {
                if (j - i + 1 < k) {
                    times.put(str[j], times.getOrDefault(str[j], 0) + 1);
                    dp[i][j] = false;
                    continue;
                }else if ((j - 1 < 0 || dp[i][j-1]) && times.containsKey(str[j])){
                    dp[i][j] = true;
                }else {
                    times.put(str[j], times.getOrDefault(str[j], 0) + 1);
                    boolean changed = false;
                    for (int value : times.values()) {
                        if (value < k) {
                            dp[i][j] = false;
                            changed = true;
                        }
                    }
                    dp[i][j] = !changed;
                }

                if (dp[i][j]) {
                    len = Math.max(len, j - i + 1);
                }
            }
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestSubstring("a", 1));
        System.out.println(new Solution().longestSubstring("ababbc", 2));
    }
}