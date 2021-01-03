package day20.滑动窗口最大值;


import java.util.*;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 */


/**
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * [1,0] [3,1] [-1,2]  -> [3,1], [1,0], [-1,2] <- [-3,3]
 * res.append(3] ,
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * <p>
 * 输入：nums = [1,-1], k = 1
 * 输出：[1,-1]
 * <p>
 * 输入：nums = [9,11], k = 2
 * 输出：[11]
 * <p>
 * 输入：nums = [4,-2], k = 2
 * 输出：[4]
 */
class Solution {

    /**
     * 使用双队列：优先队列 + 顺序队列(数组)
     * 超时
     */
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        Queue<Integer> q = new PriorityQueue<>(k, (o1, o2) -> (o2 - o1));
        int[] queue = new int[k];
        int l = -1;
        int[] res = new int[n - k + 1];
        int j = 0;
        for (int i = 0; i < k; i++) {
            q.offer(nums[i]);
            queue[(++l) % k] = nums[i];
        }

        for (int i = k; i < n; i++) {
            int first = queue[(l + 1) % k];
            res[j++] = q.peek();
            q.remove(first);
            queue[(++l) % k] = nums[i];
            q.offer(nums[i]);
        }
        res[j] = q.peek();
        return res;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {

        int n = nums.length;

        int[] window = new int[k];
        int w = -1;


        int[] queue = new int[k];
        int q = -1;

        int[] res = new int[n - k + 1];
        int r = -1;

        int max = -10001;
        for (int i = 0; i < k; i++) {
            max = Math.max(max, nums[i]);
            window[++w] = nums[i];
            queue[(++q) % k] = nums[i];
        }
        res[++r] = max;
        for (int i = k; i < n; i++) {
            int first = queue[(q + 1) % k];
            int index = getIndex(window, first);
            queue[(++q) % k] = nums[i];
            window[index] = nums[i];
            if (first == max) {
                max = -100001;
                for (int num : window) {
                    max = Math.max(num, max);
                }
            } else {
                max = Math.max(max, nums[i]);
            }
            res[++r] = max;
        }
        return res;
    }

    private int getIndex(int[] window, int e) {
        for (int i = 0; i < window.length; i++) {
            if (window[i] == e) {
                return i;
            }
        }
        throw new IllegalArgumentException("Cannot find " + e);
    }

    public int[] maxSlidingWindow3(int[] nums, int k) {

        /*
         *  输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
         *  输出：[3,3,5,5,6,7]
         *  [1,0] [3,1] [-1,2]  -> [3,1], [1,0], [-1,2] <- [-3,3]
         *  res.append(3] ,
         */

        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1]);

        for (int i = 0; i < k; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] res = new int[n - k + 1];
        int r = -1;
        res[++r] = pq.peek()[0];
        for (int i = k; i < n; i++) {
            pq.offer(new int[]{nums[i], i});

            //仅弹出队列中影响最大值的数，不实时更新队列数据
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }

            res[++r] = pq.peek()[0];
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(
                new Solution().maxSlidingWindow3(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        System.out.println(Arrays.toString(
                new Solution().maxSlidingWindow3(new int[]{1, -1}, 1)));
        System.out.println(Arrays.toString(
                new Solution().maxSlidingWindow3(new int[]{-1}, 1)));

    }
}