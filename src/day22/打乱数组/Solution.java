package day22.打乱数组;


import java.util.Arrays;
import java.util.Random;

/**
 * 给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。
 *
 * 实现 Solution class:
 *
 * Solution(int[] nums) 使用整数数组 nums 初始化对象
 * int[] reset() 重设数组到它的初始状态并返回
 * int[] shuffle() 返回数组随机打乱后的结果
 *
 * */
 
class Solution {

    int[] nums;
    int size;
    int[] numsReset;
    Random random;

    public Solution(int[] nums) {
        size = nums.length;
        this.nums = nums;
        numsReset = nums.clone();
        random = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        nums = numsReset.clone();
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i = size - 1; i >= 0 ; i--) {
            int randomInt = random.nextInt(i + 1);
            swap(nums, randomInt, i);
        }
        return nums;
    }

    private void swap(int[] nums, int index1, int index2){
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

    public static void main(String[] args) {
//        Solution solution = new Solution(new int[]{1,2,3,4,5,6});
//        System.out.println(Arrays.toString(solution.shuffle()));
//        System.out.println(Arrays.toString(solution.reset()));
//        System.out.println(Arrays.toString(solution.shuffle()));

        for (int i = 0; i < 50; i++) {
            System.out.print(new Random().nextInt(10) + " ");
        };

    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */