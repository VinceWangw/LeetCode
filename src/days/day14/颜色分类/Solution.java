package days.day14.颜色分类;



/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 进阶：
 *
 * 你可以不使用代码库中的排序函数来解决这道题吗？
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 *
 * 示例 1：
 *
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 示例 2：
 *
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 */


class Solution {

    // 计数法，两次遍历
    public void sortColors(int[] nums) {
        int zeros = 0, ones = 0, twos = 0;
        for (int num : nums){
            if (num == 0){
                zeros ++;
            }else if (num == 1){
                ones ++;
            }else if (num == 2){
                twos ++;
            }else{
                throw new IllegalArgumentException("num is error!");
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (zeros > 0){
                nums[i] = 0;
                zeros --;
            }else if (ones > 0){
                nums[i] = 1;
                ones --;
            }else {
                nums[i] = 2;
            }
        }
    }
    // 快排法：一次遍历 O(n),O(1)
    public void sortColors2(int[] nums) {

        int zeros = -1;
        int twos = nums.length;
        int i = 0;
        while (i < twos) {
            if (nums[i] == 1){
                i ++;
            }else if (nums[i] == 2){
                swap(nums, i , --twos);
            }else {
                swap(nums, ++ zeros, i ++);
            }
        }
    }
    private void swap(int[] nums, int i ,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}