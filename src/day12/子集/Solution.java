package day12.子集;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {

    List<List<Integer>> lists;

    public List<List<Integer>> subsets(int[] nums) {

        lists = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        __subsets(nums, 0, list);
        return lists;
    }

    private void __subsets(int[] nums, int num, LinkedList<Integer> list) {

        lists.add(new ArrayList<>(list));

        for (int i = num; i < nums.length; i++) {
            list.add(nums[i]);
            __subsets(nums, i + 1, list);
            list.removeLast();

        }
    }
    public List<List<Integer>> subsets2(int[] nums) {

        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<>());

        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = i; j >= 0; j --){
                list.add(nums[j]);
                lists.add(new ArrayList<>(list));
            }
        }

        return lists;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3};
        System.out.println(new Solution().subsets2(nums));
    }
}




class Solution2 {

    List<List<Integer>> lists;
    public List<List<Integer>> subsets(int[] nums) {
        lists = new ArrayList<>();
        LinkedList<Integer> curList = new LinkedList<>();
        __subsets(nums, 0, curList);
        return lists;
    }

    private void __subsets(int[] nums, int begining, LinkedList<Integer> curList){

        lists.add(new ArrayList<>(curList));

        for (int i = begining; i < nums.length; i++) {
            curList.add(nums[i]);
            __subsets(nums, i + 1, curList);
            curList.removeLast();
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(new Solution().subsets(nums));
    }
}