package day9.递增的三元子序列;


import java.util.Arrays;

/**
 * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
 * <p>
 * 数学表达式如下:
 * <p>
 * 如果存在这样的 i, j, k,且满足 0 ≤ i < j < k ≤ n-1，
 * 使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: true
 */

/**
 * 动态规划，时间复杂度：O(n^2)，空间复杂度：O(n)
 */
class Solution {
    public boolean increasingTriplet(int[] nums) {

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = dp[j] + 1;
                }
                if (dp[i] >= 3) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 4, 5, 6, 1};
        System.out.println(new Solution().increasingTriplet(nums));
    }
}

/**
 * 方法二：三元组记录 small，mid，发现比mid大的数时，返回true
 * 时间复杂度：O(n), 空间复杂度：O(1)
 */
class Solution2 {
    public boolean increasingTriplet(int[] nums) {

        int len = nums.length;
        if (len < 3) {
            return false;
        }

        int small = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= small) {
                small = num;
            } else if (num <= mid) {
                mid = num;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,-2,6};
        System.out.println(new Solution().increasingTriplet(nums));
        System.out.println(new Solution2().increasingTriplet(nums));
    }
}