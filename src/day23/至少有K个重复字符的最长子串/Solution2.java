package day23.至少有K个重复字符的最长子串;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。 输入: s = "aaabb", k = 3 输出: 3 最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 * 输入: s = "ababbc", k = 2 输出: 5 最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 */

/**
 * 分治
 */

class Solution2 {
    public int longestSubstring(String s, int k) {
        char[] str = s.toCharArray();
        int n = str.length;
        return findLongestSubstring(str, k, 0, n - 1);
    }

    private int findLongestSubstring(char[] str, int k, int begin, int end) {
        if (begin > end) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = begin; i <= end; i++) {
            map.put(str[i], map.getOrDefault(str[i], 0) + 1);
        }
        Set<Character> breakPoint = new HashSet<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() < k) {
                breakPoint.add(entry.getKey());
            }
        }

        for (int i = begin; i <= end; i++) {
            if (breakPoint.contains(str[i])) {
                return Math.max(findLongestSubstring(str, k, begin, i - 1),
                        findLongestSubstring(str, k, i + 1, end));
            }
        }
        return end - begin + 1;
    }

    public static void main(String[] args) {
 //       System.out.println(new Solution2().longestSubstring("a", 1));
        System.out.println(new Solution2().longestSubstring("ababbc", 2));
    }
}