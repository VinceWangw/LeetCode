package days.day25.计算右侧小于当前元素的个数;


import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个整数数组 nums，按要求返回一个新数组 counts。
 * 数组 counts 有该性质： counts[i] 的值是 nums[i] 右侧小于 nums[i] 的元素的数量。
 *
 *
 * 输入：nums = [5,2,6,1]
 * 输出：[2,1,1,0]
 * 解释：
 * 5 的右侧有 2 个更小的元素 (2 和 1)
 * 2 的右侧仅有 1 个更小的元素 (1)
 * 6 的右侧有 1 个更小的元素 (1)
 * 1 的右侧有 0 个更小的元素
 *
 * */


/**
 * 1. 暴力求解： O(n^2)
 * */

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        List<Integer> list = new LinkedList<>();
        if (n == 0) return list;
        int[] res = new int[n];
        res[n-1] = 0;
        for (int i = n - 2; i >= 0 ; i--) {
            int count = 0;
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > nums[j]){
                    count ++;
                }
            }
            res[i] = count;
        }
        for (int num : res){
            list.add(num);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countSmaller(new int[]{10,4,13,14,6,9,2}));

    }
}