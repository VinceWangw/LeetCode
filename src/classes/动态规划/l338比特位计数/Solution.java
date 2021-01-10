package classes.动态规划.l338比特位计数;
//给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
//
// 示例 1: 
//
// 输入: 2
//输出: [0,1,1] 
//
// 示例 2: 
//
// 输入: 5
//输出: [0,1,1,2,1,2] 
//
// 进阶: 
//
// 
// 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？ 
// 要求算法的空间复杂度为O(n)。 

import java.util.Arrays;

class Solution {
    public int[] countBits(int num) {
        // 000000       0       0
        // 0000 1       1       1       1
        // 000 10       1       2       1
        // 000 11       2       3       2+1
        // 00 100       1       4       1
        // 00 101       2       5       4+1
        // 00 110       2       6       4+2
        // 00 111       3       7       4+2+1
        // 01 000       1       8       1

        int[] dp = new int[num + 1];
        boolean[] isPow2 = new boolean[num + 1];
        dp[0] = 0;


        for (int i = 1; i < num + 1; i *= 2) {
            isPow2[i] = true;
        }

        for (int i = 1; i < num + 1; i++) {
            int n = 1;
            if (isPow2[i]) {
                dp[i] = 1;
            } else {
                do {
                    n *= 2;
                } while (n * 2 < i);
                dp[i] = dp[n] + dp[i - n];
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().countBits(10)));
    }
}
