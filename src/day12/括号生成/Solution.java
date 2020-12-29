package day12.括号生成;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 功能描述: TODO
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 * @return List of String
 * */

class Solution {

    List<String> list;
    public List<String> generateParenthesis(int n) {
        list = new ArrayList<>();
        if (n == 0) {
            return list;
        }

        gp(n,0,0,new StringBuilder());
        return list;
    }

    private void gp(int n, int left, int right, StringBuilder str){
        if (str.length() == 2 * n){
            list.add(str.toString());
            return;
        }

        if (left < n){
            str.append("(");
            gp(n, left + 1, right, str);
            str.deleteCharAt(str.length()-1);
        }
        if (right < left){
            str.append(")");
            gp(n, left, right + 1, str);
            str.deleteCharAt(str.length()-1);
        }

    }

    public static void main(String[] args) {

        System.out.println(new Solution().generateParenthesis(4));

    }


}