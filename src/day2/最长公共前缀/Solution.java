package day2.最长公共前缀;

/**
 * 类名: Solution
 * 描述: TODO
 * 姓名: wangf
 * 日期: 2020-12-15 14:55
 **/

/**
 * 功能描述: TODO
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * @return 
 * */
 
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if (n == 0) return "";
        if (n == 1) return strs[0];
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String s = strs[i];
            res = getCommonPrefix(res, s);
        }
        return res;
    }

    private String getCommonPrefix(String s1, String s2){
        int m1 = s1.length();
        int m2 = s2.length();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < m1 && i < m2; i++) {
            if (s1.charAt(i) == s2.charAt(i)){
                res.append(s1.charAt(i));
            }else{
                break;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"dog","dog","do"};
        System.out.println(new Solution().longestCommonPrefix(strs));
    }
}