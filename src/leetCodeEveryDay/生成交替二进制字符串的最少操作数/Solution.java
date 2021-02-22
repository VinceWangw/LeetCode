package leetCodeEveryDay.生成交替二进制字符串的最少操作数;

class Solution {

    public int minOperations(String s) {

        int n = s.length();
        if (n == 1 || n == 0){
            return 0;
        }
        int[] dp = new int[n];

        char pre0 = s.charAt(0);
        char pre1 = pre0 == '0' ? '1' : '0';

        int count0 = 0, count1 = 1;

        // 1 , 1 , 0
        for (int i = 1; i < n; i++) {
            char cur = s.charAt(i);
            if (cur == pre0){
               count0 ++;
               pre0 = pre1;
               pre1 = cur;
            }else{
                count1 ++;
                pre1 = pre0;
                pre0 = cur;
            }
            dp[i] = Math.min(count0, count1);
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minOperations("0100"));
        System.out.println(new Solution().minOperations("010"));
        System.out.println(new Solution().minOperations("1111"));
        System.out.println(new Solution().minOperations("0"));
        System.out.println(new Solution().minOperations("1"));
        System.out.println(new Solution().minOperations("000"));
    }
}