package day8.无重复字符的最长子串;

import com.sun.org.apache.bcel.internal.generic.ARETURN;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 *
 * 示例1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {

        int n = s.length();
        StringBuilder sb = new StringBuilder();

        int dpi = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            String str = sb.toString();
            if (str.contains(s.substring(i,i+1))){
                sb = new StringBuilder();
                sb.append(str.substring(str.indexOf(s.charAt(i))+1));
                sb.append(s.charAt(i));
                dpi = sb.length();
            }else {
                sb.append(s.charAt(i));
                dpi = dpi + 1;
            }

            max = Math.max(max,dpi);
        }
        return max;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{
                "abcabcbb",
                "bbbbb",
                "",
                "dvdf"
        };

        for (String str : strs){
            int n = new Solution().lengthOfLongestSubstring(str);
            System.out.println(str + ": " + n);
        }

    }
}
class Solution2 {
    public int lengthOfLongestSubstring(String s) {

        int n = s.length();

        Set<Character> set = new HashSet<>();
        int dpi = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            set.clear();
            int count = 1;
            set.add(s.charAt(i));
            for (int j = i-1; j >= 0 ; j--) {
                if (!set.contains(s.charAt(j))){
                    set.add(s.charAt(j));
                    count ++;
                }else {
                    break;
                }
            }
            dpi = count;
            max = Math.max(max,dpi);
        }
        return max;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{
                "abcabcbb",
                "bbbbb",
                "",
                "dvdf"
        };

        for (String str : strs){
            int n = new Solution2().lengthOfLongestSubstring(str);
            System.out.println(str + ": " + n);
        }

    }
}

//滑动窗口
class Solution3{
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = -1;
        int max = 0;
        Set<Character> set = new HashSet<>();
        while (i < s.length()){
            if (j+1 < s.length() && !set.contains(s.charAt(j+1))){
                j ++;
                set.add(s.charAt(j));
                max = Math.max(max,j-i+1);
            }else {
                set.remove(s.charAt(i));
                i ++;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        String[] strs = new String[]{
                "abcabcbb",
                "bbbbb",
                "",
                "dvdf"
        };

        for (String str : strs){
            int n = new Solution3().lengthOfLongestSubstring(str);
            System.out.println(str + ": " + n);
        }

    }
}
