package day2.实现strStr;

/**
 * 类名: olution
 * 描述: TODO
 * 姓名: wangf
 * 日期: 2020-12-15 14:07
 **/

/**
 *功能描述: TODO
 * 实现strStr()函数。
 *
 * 给定一个haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回 -1
 *
 * @return
 **/

class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.equals("") || needle.length() == 0) {
            return 0;
        }
        int i = 0;
        int j = 0;
        int res = -1;
        int length = 0;
        while(i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) != needle.charAt(j)) {
                i ++;
            }
            res = i;
            for (j = 0; j < needle.length(); j++) {
                if (i == haystack.length()) {
                    return -1;
                }
                if (haystack.charAt(i) == needle.charAt(j)) {
                    i ++;
                    length ++;
                }else {
                    i = i - length + 1;
                    length = 0;
                    j = 0;
                    break;
                }
            }
        }
        if (j == needle.length()) {
            return res;
        }else {
            return -1;
        }
    }
}