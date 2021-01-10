package days.day03.最大子序和;

/**
 * 类名: Solution
 * 描述: TODO
 * 姓名: wangf
 * 日期: 2020-12-16 14:59
 **/

/**
 *功能描述: TODO
 * 给定一个整数数组 nums，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释:连续子数组[4,-1,2,1] 的和最大，为6。
 *
 * 进阶:
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解
 * @return sum
 * */

class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        //dp[n]表示以n为结尾的子数组最大和
        //dp[i] = max(dp[i-1] + nums[i], nums[i])
        //返回dp最大值
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
        }
        int max = nums[0];
        for (int num : dp) {
            if (num > max) max = num;
        }
        return max;
    }

    //优化空间O(n)->O(1)
    public int maxSubArray2(int[] nums) {
        int nums1 = 0;
        int max = nums[0];
        for (int num : nums) {
            nums1 = Math.max(nums1 + num, num);
            max = Math.max(nums1, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new Solution().maxSubArray2(nums));
    }
}