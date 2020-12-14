package day1.旋转数组;

/**
 * 类名: Solution
 * 描述: TODO
 * 姓名: wangf
 * 日期: 2020-12-14 14:32
 **/
class Solution {
    public void rotate(int[] nums, int k) {

        if (nums.length == 1) return;
        if (nums.length < k) k = k % nums.length;

        reverse(nums, 0, nums.length - k - 1) ;
        reverse(nums, nums.length - k , nums.length - 1);
        reverse(nums, 0 ,nums.length - 1);

    }

    private void reverse(int[] nums, int begin, int end){
        while (begin <= end){
            int temp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = temp;
            begin ++;
            end --;
        }
    }

    public static void main(String[] args) {

        Solution s = new Solution();
        int[] nums = new int[]{1, 2, 3, 4};

        s.rotate(nums , 5);
        s.printArr(nums);

//        s.reverse(nums, 0 ,2);
//        s.reverse(nums, 3,nums.length - 1);
//        s.printArr(nums);


    }

    private void printArr(int[] nums){
        System.out.println();
        for (int num : nums){
            System.out.print(num + ", ");
        }
    }
}