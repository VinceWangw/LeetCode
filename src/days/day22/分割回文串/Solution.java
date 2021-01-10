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

public class Solution {

    int len;
    List<List<String>> res;

    public List<List<String>> partition(String s) {
        len = s.length();
        res = new ArrayList<>();

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

            if (!checkPalindrome(s, beginIndex, i)){
                continue;
            }

            stack.addLast(s.substring(beginIndex, i + 1));
            findPalindrome(s, i + 1, stack);
            stack.removeLast();
        }
    }


    private boolean checkPalindrome(String str, int left, int right) {
        // 严格小于即可
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().partition("aaba"));
    }
}
