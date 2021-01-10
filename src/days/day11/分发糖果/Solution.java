package days.day11.分发糖果;

import java.util.Arrays;

/**
 *功能描述: TODO
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 *
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 *
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 *
 * 示例1:
 *
 * 输入: [1,0,2]
 * 输出: 5
 * 解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
 * @return
 * */
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        //count[i] 表示：第i个熊孩子分到的糖果数。
        int[] count = new int[n];
        Arrays.fill(count, 1);
        for (int i = 0; i < n; i++) {
            if (i > 0 && ratings[i] > ratings[i-1]){
                if (count[i] <= count[i-1])
                    count[i] = count[i-1] + 1;
            }
        }

        for (int i = ratings.length - 1; i >= 0; i--) {
            if (i < ratings.length - 1 && ratings[i] > ratings[i+1]){
                if (count[i] <= count[i+1])
                    count[i] = count[i+1] + 1;
            }
        }
        int res = 0;
        for (int num : count){
            System.out.print(num + ", ");
            res += num;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,87,87,87,2,1};
        System.out.println(new Solution().candy(nums));
    }
}