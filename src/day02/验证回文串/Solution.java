package day02.验证回文串;

/**
 * 类名: Solution
 * 描述: TODO
 * 姓名: wangf
 * 日期: 2020-12-15 11:19
 **/

/**
 * 功能描述: 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * */

class Solution {
    public boolean isPalindrome(String s) {
        int len = s.length();
        String ss = s.toLowerCase();
        int i = 0;
        int j = len - 1;
        while (i < j){
            while (i < len && ! Character.isLetterOrDigit(ss.charAt(i))) i ++;
            while (j >= 0 && ! Character.isLetterOrDigit(ss.charAt(j))) j --;
            if (j < i) return true;

            if (ss.charAt(i) == ss.charAt(j)){
                i ++;
                j --;
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "0P";
        System.out.println(new Solution().isPalindrome(s));
    }
}