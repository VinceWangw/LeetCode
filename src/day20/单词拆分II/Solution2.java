package day20.单词拆分II;


import java.util.*;

public class Solution2 {

    List<String> res;
    boolean[] dp;
    public List<String> wordBreak(String s, List<String> wordDict) {
        res = new ArrayList<>();
        Set<String> words = new HashSet<>(wordDict);
        int n = s.length();

        dp = new boolean[n+1];
        dp[0] = true;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                //s[0,j] == true && wordDict.contains(s.substring(j, i))
                String st = s.substring(j,i);
                System.out.println(st);
                dp[i] = dp[j] && words.contains(st);
                if (dp[i]){
                    break;
                }
            }
        }
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
            if (words.contains(cur) && dp[s.length()]){
                if (i < s.length())
                    findWords(s, i, words, sb + cur + " ");
                else
                    findWords(s, i, words, sb + cur);
            }
        }
    }

    public static void main(String[] args) {
        String  s = "catsandog";
        String[] words = {"cats", "dog", "sand", "and", "cat"};
        System.out.println(new Solution2().wordBreak(s, Arrays.asList(words.clone())));
    }

}
