package days.day18.多数元素;


/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 输入：[3,2,3]
 * 输出：3
 *
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 *
 * */
 
class Solution {
    public int majorityElement(int[] nums) {
        int i = 0;
        int count = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == nums[i]){
                count ++;
            }else {
                count --;
            }

            if (count < 0){
                count = 1;
                i = j;
            }
        }
        return nums[i];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().majorityElement(new int[]{3,2,3}));
        System.out.println(new Solution().majorityElement(new int[]{2,2,1,1,1,2,2}));
        System.out.println(new Solution().majorityElement(new int[]{0}));
        System.out.println(new Solution().majorityElement(new int[]{1,2,2,3,3,3,3}));
    }
}