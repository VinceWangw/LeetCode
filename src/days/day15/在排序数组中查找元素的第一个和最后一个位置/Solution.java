package days.day15.在排序数组中查找元素的第一个和最后一个位置;


import java.util.Arrays;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 进阶：你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 *
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 * */
 
class Solution {
    public int[] searchRange(int[] nums, int target) {

        if (nums.length == 0){
            return new int[]{-1, -1};
        }

        int index = find(nums, target, 0, nums.length - 1);
        if (index == -1){
            return new int[]{-1, -1};
        }

        int l = index, r = index;
        while (l >= 1 && nums[l-1] == target){
            l--;
        }
        while (r <= nums.length - 2 && nums[r+1] == target){
            r++;
        }
        return new int[]{l, r};
    }

    private int find(int[] nums, int target, int left, int right) {

        if (left > right){
            return -1;
        }
        if (left == right){
            if (nums[left] == target)
                return left;
            else
                return -1;
        }
        int mid = left + (right - left) / 2;
        if (nums[mid] > target){
            return find(nums, target, left, mid - 1);
        }else if (nums[mid] < target){
            return find(nums, target, mid + 1, right);
        }else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,2};
        System.out.println(Arrays.toString(new Solution().searchRange(nums, 1)));
    }
}