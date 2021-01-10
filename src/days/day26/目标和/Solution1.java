package days.day26.目标和;

/**
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。
 * 对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 *
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 *
 *
 * 输入：nums: [1, 1, 1, 1, 1], S: 3
 * 输出：5
 *
 */
class Solution1 {
    public int findTargetSumWays(int[] nums, int S) {
        int n = nums.length;
        return findWays(nums, n-1, S);
    }

    private int findWays(int[] nums, int end, int s) {
        if (end < 0){
            return s == 0 ? 1 : 0;
        }

        return findWays(nums, end - 1, s - nums[end]) +
                findWays(nums, end - 1, s + nums[end]);
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }


}