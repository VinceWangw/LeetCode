package day12.全排列;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 功能描述: 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * */

class Solution {

    List<List<Integer>> lists;
    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {

        used = new boolean[nums.length];
        lists = new ArrayList<>();
        LinkedList<Integer> curList = new LinkedList<>();
        __permute(nums, 0 , curList);
        return lists;
    }

    private void __permute(int[] nums, int begin, LinkedList<Integer> curList){
        if (begin == nums.length){
            List<Integer> addList = new ArrayList<>(curList);
            lists.add(addList);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                curList.add(nums[i]);
                used[i] = true;
                __permute(nums, begin + 1, curList);
                curList.removeLast();
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(new Solution().permute(nums));
    }

}
class Solution2 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            System.out.println("添加的List是: ");
            System.out.println(output);
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(new Solution2().permute(nums));
    }
}