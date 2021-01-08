package day25.计数质数;


import java.util.Arrays;

/**
 * 统计所有小于非负整数 n 的质数的数量。
 */
class Solution {
    public int countPrimes(int n) {

        boolean[] isprime = new boolean[n];
        Arrays.fill(isprime, true);
        for (int i = 2; i * i < n; i++) {
            if (isPrimes(i)){
                for (int j = i * i; j < n; j+=i) {
                    isprime[j] = false;
                }
            }
        }
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (isprime[i])
                cnt ++;
        }
        return cnt;

    }

    private boolean isPrimes(int num){
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countPrimes(100));
        for (int i = 2; i < 100; i++) {
            if (new Solution().isPrimes(i)){
                System.out.print(i + "  ");
            }
        }
    }
}