package days.day24.最大数;


import java.util.Arrays;

/**
 * 给定一组非负整数 nums，重新排列它们每个数字的顺序（每个数字不可拆分）使之组成一个最大的整数。
 *
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 *
 * 输入：nums = [10,2]
 * 输出："210"
 *
 * 输入：nums = [3[3],30,34,5,9]
 * 输出："9 5 34 3[3] 30"
 *
 * 输入：nums = [3,31,30,35]    [2,31,30,35]     [4,31,30,35]          [323 340 3[33] 333]
 * 输出：       "35  3[3]  31  30"    "35 31 30 2"     "4 35 31 30"    340 333 3 323
 *
 * 输入：nums = [10]
 * 输出："10"
 *
 */
class Solution {
    public String largestNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();

        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strs, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        for(String str : strs){
            sb.append(str);
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        int[] nums = new int[]{3,30,34,5,9};
        System.out.println(new Solution().largestNumber(nums));
    }
}