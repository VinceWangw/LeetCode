package days.day20.单词拆分II;

import java.util.*;


/**
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 *
 * 说明：
 *
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 *  "cats and dog",
 *  "cat sand dog"
 * ]
 *
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * 输出:
 * [
 *  "pine apple pen apple",
 *  "pineapple pen apple",
 *  "pine applepen apple"
 * ]
 *
 * 输入:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出:
 * []
 *
 */


/**
 * 回溯，超时
 */
class Solution {

    List<String> res;
    public List<String> wordBreak(String s, List<String> wordDict) {
        res = new ArrayList<>();
        Set<String> words = new HashSet<>(wordDict);
        findWords(s, 0, words, "");
        return res;
    }

    private void findWords(String s, int beginning, Set<String> words, String sb) {
        if (beginning == s.length()){
            res.add(sb);
            return;
        }

        for (int i = beginning + 1 ; i <= s.length(); i++) {
            String cur = s.substring(beginning,i);
            if (words.contains(cur)){
                if (i < s.length())
                    findWords(s, i, words, sb + cur + " ");
                else
                    findWords(s, i, words, sb + cur);
            }
        }
    }

    public static void main(String[] args) {
        String  s = "catsanddog";
        String[] words = {"cats", "dog", "sand", "and", "cat"};
        System.out.println(new Solution().wordBreak(s, Arrays.asList(words.clone())));
    }
}