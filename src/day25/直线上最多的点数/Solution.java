package day25.直线上最多的点数;


import util.ListNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
 *
 *
 * 输入: [[1,1],[2,2],[3,3]]
 * 输出: 3
 * 解释:
 * ^
 * |
 * |     o
 * |   o
 * | o
 * +------------->
 * 0 1 2 3  4
 *
 * 输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * 输出: 4
 * 解释:
 * ^
 * |
 * |  o
 * |     o      o
 * |        o
 * |    o      o
 * +------------------->
 * 0 1 2 3 4 5 6
 *
 * */

class Solution {
    class Line{
        double k;
        double b;

        public Line(double k, double b) {
            this.k = k;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Line line = (Line) o;
            return Double.compare(line.k, k) == 0 &&
                    Double.compare(line.b, b) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(k, b);
        }
    }
    public int maxPoints(int[][] points) {
        Map<Line, Integer> times = new HashMap<>();

        boolean[] used = new boolean[points.length];

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (used[i] && used[j]){
                    continue;
                }
                double k = getK(points[i], points[j]);
                double b = getB(points[i], k);
                Line line = new Line(k, b);
                if (!times.containsKey(line)){
                    times.put(line, 2);
                    used[i] = true;
                    used[j] = true;
                }else {
                    times.put(line, times.get(line) + 1);
                    used[i] = true;
                    used[j] = true;
                }
            }
        }
        int max = 0;
        for (int v : times.values()){
            max = Math.max(max, v);
        }
        return max;
    }
    private double getK(int[] points1, int[] points2){
        if (points1[0] == points2[0]){
            return Double.MAX_VALUE;
        }

        return (double) (points1[1] - points2[1]) / (double)(points1[0] - points2[0]);
    }
    private double getB(int[] points1, double k){
        return points1[1] - k * points1[0];
    }

    public static void main(String[] args) {
        int[][] points = {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
        int[][] points2 = {{1,1},{3,3},{2,2}};

        System.out.println(new Solution().maxPoints(points));
        System.out.println(new Solution().maxPoints(points2));
    }
}