package day2.反转字符串;

/**
 * 类名: Solution
 * 描述: TODO
 * 姓名: wangf
 * 日期: 2020-12-15 10:00
 **/
class Solution {
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        while (i <= j){
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i ++;
            j --;
        }
    }

    public static void main(String[] args) {
        char[] s = new char[]{'a','b','c','d'};
        new Solution().reverseString(s);
        for (char c : s){
            System.out.print(c + ", ");
        }

    }
}