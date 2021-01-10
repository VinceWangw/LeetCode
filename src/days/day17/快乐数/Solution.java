package days.day17.快乐数;


import java.util.HashSet;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 *「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为 1，那么这个数就是快乐数。
 *
 * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
 *
 */
class Solution {

    /**
     * 使用集合记录， 发现循环就return false；
     */
    public boolean isHappy(int n) {

        HashSet<Integer> set = new HashSet<>();
        while (n != 1){
            if (set.contains(n)){
                return false;
            }
            set.add(n);
            n = squareSum(n);
        }
        return true;

    }

    /**
     * 使用快慢指针
     */
    public boolean isHappy2(int n) {

        int slow = n, fast = squareSum(n);
        while (slow != fast){
            slow = squareSum(slow);
            fast = squareSum(squareSum(fast));
        }
        return slow == 1;
    }

    private int squareSum(int n){
        int sum = 0;
        while (n != 0){
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }
}