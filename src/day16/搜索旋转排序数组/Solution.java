package day16.搜索旋转排序数组;


/**
 * 升序排列的整数数组 nums 在预先未知的某个点上进行了旋转（例如， [0,1,2,4,5,6,7] 经旋转后可能变为 [4,5,6,7,0,1,2] ）。
 *
 * 请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1。
 *
 * 示例 1：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 示例 2：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：nums = [1], target = 0
 * 输出：-1
 * */

class Solution {
    public int search(int[] nums, int target) {
        int res = -1;
        int n = nums.length;
        int i = 0;
        while ( i < n ) {
            if (i + 1 < n && nums[i] < nums[i+1]){
                i ++;
            }else {
                break;
            }
        }
        if (i == n - 1){
            if(nums[i] == target){
                return i;
            }
            if (nums[0] == target){
                return 0;
            }
            return -1;
        }else {
            int j = i + 1;
            res = j;
            while (j < n - 1){
                if (nums[j] > nums[j + 1]){
                    return -1;
                }
                j ++;
            }
            return nums[res] == target ? res : -1;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        System.out.println(new Solution().search(nums, 0));
        System.out.println(new Solution().search(new int[]{1}, 1));
        System.out.println(new Solution().search(new int[]{1,3}, 1));
    }
}