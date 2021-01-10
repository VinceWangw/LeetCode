package days.day01.多数元素;

/**
 * 类名: Solution
 * 描述: TODO
 * 姓名: wangf
 * 日期: 2020-12-14 10:16
 **/
class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;
        for (int num : nums){
            if (count == 0){
                candidate = num;
            }
            if (candidate == num){
                count ++;
            }else {
                count --;
            }

        }
        return candidate;

    }

    public static void main(String[] args) {
        int[] num = new int[]{3,3,4};
        System.out.println(new Solution().majorityElement(num));
    }
}