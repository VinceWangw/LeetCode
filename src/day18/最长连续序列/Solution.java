package day18.最长连续序列;


import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？
 *
 * 输入：nums = [100,4,200,1,3,2]
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 * */

class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            set.add(num);
        }
        int maxLength = 0;
        for (int num : nums){
            if (!set.contains(num-1)){
                int curLength = 1;
                int curNum = num;
                while (set.contains(curNum + 1)){
                    curLength += 1;
                    curNum += 1;
                }
                maxLength = Math.max(maxLength, curLength);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }
}