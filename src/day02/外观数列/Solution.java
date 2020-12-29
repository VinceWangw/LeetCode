package day02.外观数列;

/**
 * 类名: Solution
 * 描述: TODO
 * 姓名: wangf
 * 日期: 2020-12-15 14:34
 **/
class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";

        StringBuilder res = new StringBuilder();
        String s = countAndSay(n - 1);
        int i = 0;

        while (i < s.length()) {
            int count = 1;
            int j = i + 1;
            while (j < s.length() && s.charAt(i) == s.charAt(j)) {
                i++;
                j++;
                count++;
            }
            res.append(count);
            res.append(s.charAt(i));
            i = j;
        }

        return res.toString();

    }

    public static void main(String[] args) {

        System.out.println(new Solution().countAndSay(50));

    }
}