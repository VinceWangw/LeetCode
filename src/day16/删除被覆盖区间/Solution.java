package day16.删除被覆盖区间;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 *给你一个区间列表，请你删除列表中被其他区间所覆盖的区间。
 *
 * 只有当 c <= a 且 b <= d 时，我们才认为区间 [a,b) 被区间 [c,d) 覆盖。
 *
 * 在完成所有删除操作后，请你返回列表中剩余区间的数目。
 *
 * 示例：
 *
 * 输入：intervals = [[1,4],[3,6],[2,8]]
 * 输出：2
 * 解释：区间 [3,6] 被区间 [2,8] 覆盖，所以它被删除了。
 * */

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {

        int m = intervals.length;
        Arrays.sort(intervals, (o1, o2) -> o1[0]-o2[0] == 0 ? o2[1] - o1[1] : o1[0]-o2[0]);

        for (int[] nums : intervals){
            System.out.println(Arrays.toString(nums));
        }
        int i = 0;
        int count = m;
        while ( i < m-1) {
            if (i < m-1 && isCoverd(intervals[i], intervals[i+1])){
                intervals[i+1] = intervals[i];
                for (int[] nums : intervals){
                    System.out.println(Arrays.toString(nums));
                }
                count --;
            }
            i ++;
        }
        return count;
    }

    private boolean isCoverd(int[] interval1, int[] interval2){
        int left1 = interval1[0], left2 = interval2[0];
        int right1 = interval1[1], right2 = interval2[1];
        if (left1 <= left2 && right1 >= right2){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,4},{3,6},{2,8}};
        int[][] intervals2 = {{1,2},{1,4},{3,4}};
        int[][] intervals3 = {{3,10},{4,10},{5,11}};

        System.out.println(new Solution().removeCoveredIntervals(intervals));
        System.out.println(new Solution().removeCoveredIntervals(intervals2));
        System.out.println(new Solution().removeCoveredIntervals(intervals3));
    }
}