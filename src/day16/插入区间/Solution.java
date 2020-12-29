package day16.插入区间;


import java.util.*;

/**
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 *
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 *
 * */

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        int n = intervals.length;
        if (n == 0){
            return new int[][]{newInterval};
        }
        List<int[]> list = new ArrayList<>();
        int[][] newIntervals = Arrays.copyOf(intervals, n+1);
        newIntervals[n] = newInterval;
        Arrays.sort(newIntervals, Comparator.comparingInt(o -> o[0]));

        for (int i = 0; i < n + 1; i++) {
            int l = newIntervals[i][0], r = newIntervals[i][1];
            if (list.size() == 0 || list.get(list.size()-1)[1] < l){
                list.add(newIntervals[i]);
            }else {
                list.get(list.size()-1)[1] = Math.max(list.get(list.size()-1)[1], r);
            }
        }

        return list.toArray(new int[list.size()][2]);
    }

    public int[][] insert2(int[][] intervals, int[] newInterval) {

        List<int[]> list = new ArrayList<>();
        int n = intervals.length;
        int i;
        for (i = 0; i < n; i++) {
            if (intervals[i][1] < newInterval[0]){
                list.add(intervals[i]);
            }else {
                break;
            }
        }
        //存在合并条件，将intervals中的区间合并到newInterval，更新newInterval。
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        list.add(newInterval);
        //添加剩余区间
        while (i < intervals.length ) {
            list.add(intervals[i]);
            i++;
        }
        return list.toArray(new int[list.size()][2]);
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,2}, {3,5}, {6,7}, {8,10},{12,16}};
        int[] newInterval = new int[]{4,8};

        int[][] res = new Solution().insert(intervals, newInterval);
        System.out.println("-------------Solution1------------");
        System.out.print("{  ");
        for (int[] nums : res){
            System.out.print(Arrays.toString(nums) + "  ");
        }
        System.out.println("}");

        int[][] res2 = new Solution().insert2(intervals, newInterval);
        System.out.println("-------------Solution2------------");
        System.out.print("{  ");
        for (int[] nums : res2){
            System.out.print(Arrays.toString(nums) + "  ");
        }
        System.out.println("}");
    }
}