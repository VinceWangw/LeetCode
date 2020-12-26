

package day12.子集;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {

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