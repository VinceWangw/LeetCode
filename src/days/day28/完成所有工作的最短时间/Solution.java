package days.day28.完成所有工作的最短时间;


/**
 * 给你一个整数数组 jobs ，其中 jobs[i] 是完成第 i 项工作要花费的时间。
 *
 * 请你将这些工作分配给 k 位工人。所有工作都应该分配给工人，且每项工作只能分配给一位工人。工人的 工作时间 是完成分配给他们的所有工作花费时间的总和。请你设计一套最佳的工作分配方案，使工人的 最大工作时间 得以 最小化 。
 *
 * 返回分配方案中尽可能 最小 的 最大工作时间 。
 *
 *
 * 输入：jobs = [3,2,3], k = 3
 * 输出：3
 * 解释：给每位工人分配一项工作，最大工作时间是 3 。
 * 示例 2：
 *
 * 输入：jobs = [1,2,4,7,8], k = 2
 * 输出：11
 * 解释：按下述方式分配工作：
 * 1 号工人：1、2、8（工作时间 = 1 + 2 + 8 = 11）
 * 2 号工人：4、7（工作时间 = 4 + 7 = 11）
 * 最大工作时间是 11 。
 */
class Solution {


    public int minimumTimeRequired(int[] jobs, int k) {


        int min = -1;
        int max = 0;
        for (int job : jobs){
            max += job;
            min = Math.max(min, job);
        }

        return helper(jobs, k, min, max);
    }

    private int helper(int[] jobs, int k, int min, int max){
        if (min == max ){
            return max;
        }else {
            int mid = (min + max) >> 1;
            int nS = average(jobs, mid);
            if (nS <= k){
                int l = helper(jobs, k, min, mid);
                return  l;
            }else {
                int r = helper(jobs, k, mid + 1, max);
                return r;
            }
        }
    }
    private int average(int[] jobs, int mid){
        int res = 1;
        int sum = 0;

        for (int i = 0 ; i < jobs.length ; i ++) {
            sum += jobs[i];
            if (sum > mid){
                res += 1;
                sum = i;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minimumTimeRequired(new int[]{1,2,4,7,8}, 2));
        System.out.println(new Solution().minimumTimeRequired(new int[]{12,13,14,17,25}, 3));
    }
}