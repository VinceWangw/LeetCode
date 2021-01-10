package days.day01.只出现一次的数字;

/**
 * 类名: Solution
 * 描述: TODO
 * 姓名: wangf
 * 日期: 2020-12-14 10:04
 **/
class Solution {
    public int singleNumber(int[] nums) {

        int res = 0;
        for (int num : nums){
            res ^= num;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1,1,3};
        System.out.println(new Solution().singleNumber(nums));
    }
}