package days.day17.阶乘后的零;


import java.math.BigDecimal;

/**
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 示例 2:
 *
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 *
 */
class Solution {

    /**
     * 暴力
     */
    public int trailingZeroes(int n) {
        String num = fac(n).toString();
        int count = 0;
        int i = num.length() - 1;
        while (i >= 0 && num.charAt(i) == '0'){
            count ++;
            i --;
        }
        return count;
    }

    /**
     * 计算 5
     */
    public int trailingZeroes2(int n) {
        int count = 0;
        while (n >= 5){
            count += n / 5;
            n /= 5;
        }
        return count;
    }
    public BigDecimal fac(int n) {

        if (n == 0){
            return BigDecimal.valueOf(1);
        }

        return fac(n-1).multiply(BigDecimal.valueOf(n));
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(i + "\t" +new Solution().trailingZeroes(i) +
                    "\t" + new Solution().trailingZeroes2(i));
        }
    }
}