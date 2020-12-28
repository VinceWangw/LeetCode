package day01.移动0;

/**
 * 类名: Solution
 * 描述: TODO
 * 姓名: wangf
 * 日期: 2020-12-14 16:49
 **/
class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0 ;
        while (j < nums.length && nums[j] != 0) j++;
        while (i < nums.length){
            if (nums[i] == 0){
                while (j < nums.length && nums[j] == 0) j ++;
                if (j == nums.length) return;
                nums[i] = nums[j];
                nums[j] = 0;
            }
            print(nums);
            i ++;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        new Solution().moveZeroes(nums);
        System.out.println();
        System.out.println("==========================");
        for (int num : nums){
            System.out.print(num + ", ");
        }
    }

    private void print(int[] nums){
        System.out.println();
        for (int num : nums){
            System.out.print(num + ", ");
        }
    }
}