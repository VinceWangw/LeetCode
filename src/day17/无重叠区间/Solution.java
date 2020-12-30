package day17.无重叠区间;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 *
 * 注意:
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * 示例 1:
 *
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 * 输出: 1
 *
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * 示例 2:
 *
 * 输入: [ [1,2], [1,2], [1,2] ]
 *
 * 输出: 2
 *
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 * */


/**
 * 贪心算法 ： 按照区间结尾排序
 * */

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (o1, o2) -> o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0]);

        for (int[] nums : intervals){
            System.out.print(Arrays.toString(nums) + "  ");
        }
        int count = 1;
        int pre = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= intervals[pre][1]){
                count ++;
                pre = i;
            }
        }
        return intervals.length - count;
    }


    /**
     * 动态规划 ：dp[i] 表示 intervals[0...i] 能够保留的最多不重叠区间数
     * @return int
     * */

    public int eraseOverlapIntervals2(int[][] intervals) {
        int n = intervals.length;
        int[] dp = new int[n+1];
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        for (int[] nums : intervals){
            System.out.print(Arrays.toString(nums) + "  ");
        }
        Arrays.fill(dp, 1);
        dp[0] = 0;
        for (int i = 1; i < intervals.length + 1; i++) {
            for (int j = i - 1; j >= 1; j--) {
                if (intervals[i-1][0] >= intervals[j-1][1]){
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }
        int max = 0;

        for (int num : dp){
            max = Math.max(max, num);
        }
        return n - max;
    }

    public static void main(String[] args) {

        System.out.println("==============Solution1================");
        System.out.println(new Solution().eraseOverlapIntervals(new int[][]{{1,2},{2,3},{3,4},{1,3}}));
        System.out.println("----------------------------------------");
        System.out.println(new Solution().eraseOverlapIntervals(new int[][]{{1,2},{1,2},{1,2},{1,2}}));
        System.out.println("----------------------------------------");
        System.out.println(new Solution().eraseOverlapIntervals(new int[][]{{1,100},{11,22},{1,11},{2,12}}));
        System.out.println("----------------------------------------");
        System.out.println(new Solution().eraseOverlapIntervals(new int[][]{{0,1},{3,4},{1,2}}));
        System.out.println("----------------------------------------");
        System.out.println(new Solution().eraseOverlapIntervals(new int[][]{{1,2},{2,3},{3,4},{-100,-2},{5,7}}));

        System.out.println("\n" + "==============Solution2================");
        System.out.println(new Solution().eraseOverlapIntervals2(new int[][]{{1,2},{2,3},{3,4},{1,3}}));
        System.out.println("----------------------------------------");
        System.out.println(new Solution().eraseOverlapIntervals2(new int[][]{{1,2},{1,2},{1,2},{1,2}}));
        System.out.println("----------------------------------------");
        System.out.println(new Solution().eraseOverlapIntervals2(new int[][]{{1,100},{11,22},{1,11},{2,12}}));
        System.out.println("----------------------------------------");
        System.out.println(new Solution().eraseOverlapIntervals2(new int[][]{{0,1},{3,4},{1,2}}));
        System.out.println("----------------------------------------");
        System.out.println(new Solution().eraseOverlapIntervals2(new int[][]{{1,2},{2,3},{3,4},{-100,-2},{5,7}}));

    }
}