package day16.俄罗斯套娃信封问题;


import java.util.Arrays;

/**
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。
 * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 *
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 *
 * 说明: 不允许旋转信封。
 *
 * 示例:
 *
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 * */
 
class Solution {
    public int maxEnvelopes(int[][] envelopes) {

        int n = envelopes.length;
        Arrays.sort(envelopes, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
        int[] count = new int[envelopes.length];
        int max = 0;
        Arrays.fill(count, 1);
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j --){
                if (isCoverd(envelopes[j], envelopes[i])){
                    count[i] = Math.max(count[i], count[j] + 1);
                }
                max = Math.max(count[i], max);
            }
        }
        return max;
    }

    private boolean isCoverd(int[] interval1, int[] interval2){
        int left1 = interval1[0], left2 = interval2[0];
        int right1 = interval1[1], right2 = interval2[1];
        return left1 < left2 && right1 < right2;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxEnvelopes(new int[][]{{5,4},{6,4},{6,7},{2,3}}));
        System.out.println(new Solution().maxEnvelopes(new int[][]{{1,3},{3,5},{6,7},{6,8},{8,4},{9,5}}));
        System.out.println(new Solution().maxEnvelopes(new int[][]{}));
    }
}