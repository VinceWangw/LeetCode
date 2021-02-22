package leetCodeEveryDay.三个数的最大乘积;


import java.util.Arrays;

class Solution {
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        if (n < 3){
            return -1;
        }

        Arrays.sort(nums);

        int num1 = nums[n-3] * nums[n-2] * nums[n-1];
        int num2 = nums[0] * nums[1] * nums[n-1];

        return Math.min(num1, num2);
    }
}