package day14.同构字符串;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 *
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * 示例 1:
 *
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "foo", t = "bar"
 * 输出: false
 */
class Solution {
    public boolean isIsomorphic(String s, String t) {

        int m = s.length();
        int n = t.length();
        if (m != n) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(s.charAt(i))){
                if (map.get(s.charAt(i)) != t.charAt(i)){
                    return false;
                }
            }else{
                if (map.containsValue(t.charAt(i))){
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "abba";
        String s2 = "cddc";
        System.out.println(new Solution().isIsomorphic(s1, s2));
    }
}