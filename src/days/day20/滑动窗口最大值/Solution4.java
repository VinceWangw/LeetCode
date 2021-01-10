package days.day20.滑动窗口最大值;

import java.util.Arrays;
import java.util.LinkedList;


class Solution4 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        /*
        输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
        输出：[3,3,5,5,6,7]
         */
        int n = nums.length;
        if (n == 0 || k >= n){
            return nums;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        int[] res = new int[n-k+1];
        int r = -1;

        for (int i = 0; i < n; i++) {
            while (!queue.isEmpty() && nums[i] >= nums[queue.getLast()]){
                queue.pollLast();
            }
            queue.addLast(i);

            while (queue.peek() <= i - k){
                queue.poll();
            }
            if (i >= k - 1){
                res[++r] = nums[queue.peek()];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] res = new Solution4().maxSlidingWindow(new int[]{1,-1}, 1);
        System.out.println(Arrays.toString(res));
    }
}