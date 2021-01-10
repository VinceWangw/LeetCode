package days.day17.Excel表列序号;


/**
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 *
 * 输入: "A"
 * 输出: 1
 *
 * 输入: "AB"
 * 输出: 28
 *
 */
class Solution {
    public int titleToNumber(String s) {
        int n = s.length() ;
        int res = 0;
        for (int i = n-1; i >= 0; i--) {
            res += (s.charAt(i) - 'A' + 1) * Math.pow( 26, n-1-i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().titleToNumber("A"));
        System.out.println(new Solution().titleToNumber("B"));
        System.out.println(new Solution().titleToNumber("C"));
        System.out.println(new Solution().titleToNumber("Z"));
        System.out.println(new Solution().titleToNumber("AA"));
        System.out.println(new Solution().titleToNumber("AB"));
        System.out.println(new Solution().titleToNumber("ZY"));
        System.out.println(new Solution().titleToNumber("ZZY"));

    }
}