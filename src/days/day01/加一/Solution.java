package days.day01.加一;

/**
 * 类名: Solution
 * 描述: TODO
 * 姓名: wangf
 * 日期: 2020-12-14 16:28
 **/
class Solution {
    public int[] plusOne(int[] digits) {
        int flag = 1;
        int i = digits.length - 1;
        while (i >= 0){
            if(digits[i] + flag <= 9){
                digits[i] += 1;
                return digits;
            }
            else {
                digits[i] = 0;
                flag = 1;
            }
            i --;
        }
        if (digits[0] == 0){
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            for (int j = 1; j < res.length; j++) {
                res[j] = digits[j-1];
            }
            return res;
        }

        return digits;
    }

    public static void main(String[] args) {
        int[] digits = new int[]{9};
        int[] res = new Solution().plusOne(digits);

        for (int num : res){
            System.out.print(num + ", ");
        }
    }
}