package days.day16.摆动序列;


import java.util.Arrays;

/**
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。
 * 给定一个整数序列，返回作为摆动序列的最长子序列的长度。 通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。
 *
 * 示例 1:
 *
 * 输入: [1,7,4,9,2,5]
 * 输出: 6
 * 解释: 整个序列均为摆动序列。
 * 示例 2:
 *
 * 输入: [1,17,5,10,13,15,10,5,16,8]
 * 输出: 7
 * 解释: 这个序列包含几个长度为 7 摆动序列，其中一个可为[1,17,10,13,10,16,8]。
 * 示例 3:
 *
 * 输入: [1,2,3,4,5,6,7,8,9]
 * 输出: 2
 * */

class Solution {
    public int wiggleMaxLength(int[] nums) {

        int n = nums.length;

        if (n == 0) return 0;

        int[] dpMax = new int[n];
        int[] dpMin = new int[n];

        Arrays.fill(dpMax, 1);
        Arrays.fill(dpMin, 1);
        int max = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    dpMin[i] = Math.max(dpMax[j] + 1, dpMin[j]);
                }else if (nums[i] < nums[j]){
                    dpMax[i] = Math.max(dpMin[j] + 1, dpMax[j]);
                }
            }
            max = Math.max(dpMax[i],max);
            max = Math.max(dpMin[i],max);
        }
        System.out.println(Arrays.toString(dpMax));
        System.out.println(Arrays.toString(dpMin));
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().wiggleMaxLength(new int[]{1,7,4,9,2,5}));
        System.out.println(new Solution().wiggleMaxLength(new int[]{1,17,5,10,13,15,10,5,16,8}));
        System.out.println(new Solution().wiggleMaxLength(new int[]{1,2,3,4,5,6,7,8,9}));
        System.out.println(new Solution().wiggleMaxLength(new int[]{0,0}));
        System.out.println(new Solution().wiggleMaxLength(new int[]{10,9,12,8,8,9,12}));
        System.out.println(new Solution().wiggleMaxLength(new int[]{
                33,53,12,64,50,41,45,21,97,35,47,92,39,0,93,55,40, 46,69,42,6,95,51,68,72,9,32,84,
                34,64,6,2,26,98,3,43,30,60,3,68,82,9,97,19,27,98,99,4,30,96,37,9,78,43,64,4,65,30,
                84,90,87,64,18,50,60,1,40,32,48,50,76,100,57,29,63,53,46,57,93,98,42,80,82,9,41,55,
                69,84,82,79,30,79,18,97,67,23,52,38,74,15}));
    }
}