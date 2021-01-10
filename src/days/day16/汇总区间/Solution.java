package days.day16.汇总区间;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个无重复元素的有序整数数组 nums 。
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 * 示例 1：
 * 输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]

 * 示例 2：
 * 输入：nums = [0,2,3,4,6,8,9]
 * 输出：["0","2->4","6","8->9"]

 * 示例 3：
 * 输入：nums = []
 * 输出：[]

 * 示例 4：
 * 输入：nums = [-1]
 * 输出：["-1"]

 * 示例 5：
 * 输入：nums = [0]
 * 输出：["0"]
 * */

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();

        int n = nums.length;
        int i = 0 ;
        while (i < n) {
            int left = i;
            int right = left;
            while (i + 1 < n && nums[i+1] == nums[i] + 1){
                right ++;
                i ++;
            }
            if (left == right){
                list.add(nums[left]+"");
            }else {
                list.add(nums[left] + "->" + nums[right]);
            }
            i = right + 1;
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums1 = {0,1,2,4,5,7};
        int[] nums2 = {0,2,3,4,6,8,9};
        int[] nums3 = {};
        int[] nums4 = {-1};
        int[] nums5 = {0};
        Solution s = new Solution();
        System.out.println(s.summaryRanges(nums1));
        System.out.println(s.summaryRanges(nums2));
        System.out.println(s.summaryRanges(nums3));
        System.out.println(s.summaryRanges(nums4));
        System.out.println(s.summaryRanges(nums5));
    }
}