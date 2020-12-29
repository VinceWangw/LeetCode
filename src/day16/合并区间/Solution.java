package day16.合并区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: intervals = [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * */
 
class Solution {
    public int[][] merge(int[][] intervals) {
        int m = intervals.length;
        if (m == 0){
            return new int[0][2];
        }
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        for (int i = 0; i < m; i++) {
            int l = intervals[i][0];
            int r = intervals[i][1];

            if (list.size() == 0 || list.get(list.size()-1)[1] < l){
                list.add(new int[]{l, r});
            }else {
                list.get(list.size()-1)[1] = Math.max(list.get(list.size()-1)[1], r);
            }
        }
        return list.toArray(new int[list.size()][2]);
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{ {8,10},{2,6}, {15,18},{1,3}};
        int[][] merged = new Solution().merge(intervals);
        System.out.println("合并后：");
        for (int[] nums : merged){
            System.out.println(Arrays.toString(nums));
        }
    }
}