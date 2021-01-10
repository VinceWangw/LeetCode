package days.day03.三的幂;


/**
 * 判断是不是三的幂
 * 1, 3, 9, 27, 81, 243...
 */
class Solution {
    public boolean isPowerOfThree(int n) {
        if (n == 0){
            return false;
        }else if (n == 1){
            return true;
        }else if(n == 2){
            return false;
        }else {
            if (n % 3 != 0) return false;
            return isPowerOfThree(n / 3);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPowerOfThree(45));
    }
}