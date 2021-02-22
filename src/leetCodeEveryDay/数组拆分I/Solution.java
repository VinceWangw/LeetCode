package leetCodeEveryDay.数组拆分I;

import java.util.Arrays;

class Solution {
    public int arrayPairSum(int[] nums) {

        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i += 2) {
            res += nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,4,3,2};
        System.out.println(new Solution().arrayPairSum(nums));
        nums = new int[]{6, 2, 6, 5, 1, 2};
        System.out.println(new Solution().arrayPairSum(nums));
    }
}