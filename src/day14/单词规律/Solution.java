package day14.单词规律;


import java.util.HashMap;
import java.util.Map;

/**
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *
 * 这里的遵循指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 示例1:
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 *
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 */
class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        String[] strs = s.split(" ");

        if (strs.length != pattern.length()){
            return false;
        }
        for (int i = 0; i < pattern.length(); i ++){
            if (!map.containsKey(pattern.charAt(i))){
                if (map.containsValue(strs[i])){
                    return false;
                }
                map.put(pattern.charAt(i), strs[i]);
            }else {
                if (!map.get(pattern.charAt(i)).equals(strs[i])){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "aaaa";
        String[] strs = new String[]{
                "dog cat cat dog",
                "dog cat cat fish",
                "dog dog dog dog"
        };

        for (String str : strs){
            System.out.println(new Solution().wordPattern(pattern, str));
        }
    }
}