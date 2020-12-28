package day01.两数之和;

import java.util.HashMap;
import java.util.Map;

/**
 * 类名: Solution
 * 描述: TODO
 * 姓名: wangf
 * 日期: 2020-12-14 17:14
 **/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++ ){
            if (map.containsKey(target - nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }else{
                map.put(nums[i] , i);
            }
        }
        return null;
    }
}