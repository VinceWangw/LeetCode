package days.day18.两整数之和;


/**
 * 不使用运算符 + 和 - ，计算两整数 a 、b 之和。
 *
 *
 * 1.  a + b 的问题拆分为 (a 和 b 的无进位结果) + (a 和 b 的进位结果)
 * 2. 无进位加法使用异或运算计算得出
 * 3. 进位结果使用与运算和移位运算计算得出
 * 4. 循环此过程，直到进位为 0
 *
 * */
 
class Solution {

    /**
     * 使用递归
     * */
    public int getSum(int a, int b) {
        return (b == 0) ? a : getSum(a ^ b, (a & b) << 1);
    }

    /**
     * 使用循环
     * */
    public int getSum2(int a, int b) {
        while ( b!= 0){
            int temp = a ^ b;
            b = (a & b) << 1;
            a = temp;
        }
        return a;
    }

}