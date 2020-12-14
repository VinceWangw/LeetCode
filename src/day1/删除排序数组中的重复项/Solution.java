package day1.删除排序数组中的重复项;

/**
 * 类名: Solution
 * 描述: TODO
 * 姓名: wangf
 * 日期: 2020-12-14 10:41
 **/

class Solution {
    public int removeDuplicates(int[] nums) {

        int i = 0;
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] > nums[i]){
                swap(nums,i+1,j);
                i ++;
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicates(new int[]{1,1,1,1,1,1,1,2,2,3,4,4,4}));
        //new Solution().print(new int[]{1,1,1,1,1,1,1,2,2,3,4,4,4});

    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void printArray(int[] nums){
        for (int num : nums){
            System.out.print(num + " - ");
        }
    }
}