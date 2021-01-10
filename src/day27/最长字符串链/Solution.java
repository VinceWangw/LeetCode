package day27.最长字符串链;


//给出一个单词列表，其中每个单词都由小写英文字母组成。
// 如果我们可以在 word1 的任何地方添加一个字母使其变成 word2，那么我们认为 word1 是 word2 的前身。例如，"abc" 是 "abac
//" 的前身。
//
// 词链是单词 [word_1, word_2, ..., word_k] 组成的序列，k >= 1，其中 word_1 是 word_2 的前身，word_
//2 是 word_3 的前身，依此类推。
//
// 从给定单词列表 words 中选择单词组成词链，返回词链的最长可能长度。
//
// 输入：["a","b","ba","bca","bda","bdca"]
//输出：4
//解释：最长单词链之一为 "a","ba","bda","bdca"。
//
// 1 <= words.length <= 1000
// 1 <= words[i].length <= 16
// words[i] 仅由小写英文字母组成。

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

class Solution {

    public int longestStrChain(String[] words) {
        int n = words.length;

        Arrays.sort(words, Comparator.comparingInt(String::length));

        //dp[i] : words[0...i) 词链的最长可能长度
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int max = 1;

        for (int i = 0; i < n; i++) {
            if (words[i].length() == 1) {
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (words[i].length() - words[j].length() == 1 && moreThan(words[i], words[j])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    private boolean moreThan(String str1, String str2) {
        int i = 0, j = 0;
        while (i < str1.length() && j < str2.length()){
            if (str1.charAt(i) != str2.charAt(j)){
                i ++;
            }else {
                i ++;
                j ++;
            }
        }
        return j == str2.length();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestStrChain(new String[]{"a", "b", "ba", "bca", "bda", "bdca"}));
        System.out.println(new Solution().longestStrChain(new String[]{"a", "b", "ab", "bac"}));

    }
}