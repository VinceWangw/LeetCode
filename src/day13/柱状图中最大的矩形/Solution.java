package day13.柱状图中最大的矩形;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 *
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 * 示例:
 *
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 *
 */
class Solution {
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;
        //curMax[i] 表示 第i根柱子向两边延伸的最大面积
        int[] curMax = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            curMax[i] += heights[i];
            for (int j = i + 1; j < n && heights[j] >= heights[i] ; j++) {
                curMax[i] += heights[i];
            }
            for (int j = i - 1; j >= 0 && heights[j] >= heights[i] ; j--) {
                curMax[i] += heights[i];
            }
        }
        for (int num : curMax){
            max = Math.max(num, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,1,5,6,2,3};
        System.out.println(new Solution().largestRectangleArea(nums));
    }
}