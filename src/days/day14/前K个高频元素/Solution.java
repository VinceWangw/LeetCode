package days.day14.前K个高频元素;


import java.util.*;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 */
class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        if (k >= nums.length){
            return nums;
        }
        Queue<Map.Entry<Integer, Integer>> queue
                = new PriorityQueue<>(k, (o1, o2) -> o2.getValue() - o1.getValue());
        Map<Integer,Integer> map = new HashMap<>();

        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            queue.offer(entry);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = Objects.requireNonNull(queue.poll()).getKey();
        }
        return res;
    }

    //优化版
    public int[] topKFrequent2(int[] nums, int k) {

        Map<Integer,Integer> map = new HashMap<>();
        Queue<Integer> queue = new PriorityQueue<>(k, (o1, o2) -> map.get(o2) - map.get(o1));

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        queue.addAll(map.keySet());

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{86,3};
        int[] res = new Solution().topKFrequent2(nums,2);
        for (int num : res ){
            System.out.print(num + ", ");
        }
    }
}