package days.day12.电话号码的字母组合;


import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述: TODO
 *
 * @return 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * */


/**
 * digits : 数字字符串
 * s(digits) ： digits 所能代表的字母字符串
 * s(digits[0...n-1]
 * = letter(digits[0]) + s(digits[1...n_1]
 * = letter(digits[0]) + letter(digits[1] + s(digits[2...n-1])
 * = ...
 * */

class Solution {
    static String[] letterMap = new String[]{" ","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> list;
    public List<String> letterCombinations(String digits) {
        list = new ArrayList<>();
        if (digits.length() == 0){
            return list;
        }
        findCombinations(digits, 0, "");
        return list;
    }
    private void findCombinations(String digits, int index, String s){
        if (index == digits.length()){
            list.add(s);
            return ;
        }

        String str = letterMap[digits.charAt(index) - '0'];
        for (int i = 0; i < str.length(); i++) {
            findCombinations(digits, index + 1, s + str.charAt(i));

        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations("234"));
    }
}