package day8.三数之和;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *功能描述: TODO
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 * 示例：
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 * @return
 * */

class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        if (n < 3) { return res; }
        Arrays.sort(nums);

        //三数之和，所以第一个数后面必须还有两个数
        //[0...l...n-3]
        for (int i = 0; i < n - 2; i++) {
            if (nums[i] > 0){ break; }
            if (i > 0 && nums[i] == nums[i-1]){ continue;}
            int target = -nums[i];
            int l = i + 1, r = n - 1;
            while (l < r){
                if (nums[l] + nums[r] == target){
                    List<Integer> list = new ArrayList<>(Arrays.asList(nums[i],nums[l],nums[r]));
                    res.add(list);
                    l ++;
                    r --;
                    while (l < r && nums[l] == nums[l-1]){ l++;}
                    while (l < r && nums[r] == nums[r+1]){ r--;}

                }else if (nums[l] + nums[r] > target){
                    r --;
                }else {
                    l ++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists;
        lists = new Solution().threeSum(nums);
        new Solution().printLists(lists);
    }

    private void printList(List<Integer> list){
        System.out.print("{ ");
        for (Integer i : list){
            System.out.printf(i + ", ");
        }
        System.out.printf("}" + ", " + "\n");
    }
    private void printLists(List<List<Integer>> lists){
        System.out.println("{");
        for (List<Integer> list : lists){
            printList(list);
        }
        System.out.println("}");
    }
}