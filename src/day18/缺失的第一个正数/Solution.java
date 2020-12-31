package day18.缺失的第一个正数;


/**
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 *
 * 输入: [1,2,0]
 * 输出: 3
 *
 * 输入: [3,4,-1,1]
 * 输出: 2
 *
 * 输入: [7,8,9,11,12]
 * 输出: 1
 *
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
 * */
 
class Solution {
    public int firstMissingPositive(int[] nums) {

        int n = nums.length;
        if (n == 0) return 1;
        int i = 0;
        while (i < n){
            int memo = -1;
            while (nums[i] >= 0 && nums[i] < n && nums[i] != i && nums[i] != memo){
                memo = nums[i];
                swap(nums, i, nums[i]);
            }
            i ++;
        }
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != j){
                return j;
            }
        }
        return nums[0] == nums.length ? nums.length + 1 : nums.length;
    }
    private void swap(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().firstMissingPositive(new int[]{1,2,0}));
        System.out.println(new Solution().firstMissingPositive(new int[]{}));
        System.out.println(new Solution().firstMissingPositive(new int[]{1,1}));
        System.out.println(new Solution().firstMissingPositive(new int[]{-1}));
        System.out.println(new Solution().firstMissingPositive(new int[]{5,4,3,2,1}));
    }
}