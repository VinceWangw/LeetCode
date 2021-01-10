package days.day06.乘积最大子数组;


/**
 * 给你一个整数数组 nums，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释:子数组 [2,3] 有最大乘积 6。
 *
 */
class Solution {
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        int max = 1, min = 1;
        for (int num : nums){
            if (num < 0){
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(num * max, num);
            min = Math.min(num * min, num);

            res = Math.max(res,max);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums0 = new int[]{2,3,-2,4};
        int[] nums1 = new int[]{-2,3,-4};
        int[] nums2 = new int[]{-1,3,-4,5};
        int[] nums3 = new int[]{-2};
        int[] nums4 = new int[]{0,-1};
        System.out.println(new Solution().maxProduct(nums0));
        System.out.println(new Solution().maxProduct(nums1));
        System.out.println(new Solution().maxProduct(nums2));
        System.out.println(new Solution().maxProduct(nums3));
        System.out.println(new Solution().maxProduct(nums4));
    }
}
