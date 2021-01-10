package days.day15.数组中的第K个最大元素;


import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * 功能描述: 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *
 * */
 
class Solution {

    /**
     * 使用最小堆
     * 时间：O(nlogk) 空间：O(k)
     * */
    public int findKthLargest(int[] nums, int k) {

        Queue<Integer> heap = new PriorityQueue<>();

        for (int num : nums){
            if (heap.size() <= k - 1){
                heap.offer(num);
            }
            else {
                heap.offer(num);
                heap.remove();
            }
        }

        return heap.peek();
    }

    /**
     * 使用快速排序思想
     * 借助 partition 操作定位到最终排定以后索引为 len - k 的那个元素（特别注意：随机化切分元素）
     * 时间：O(n) 空间：O(logn)
     * */
    public int findKthLargest2(int[] nums, int k) {

        return findK(nums, 0, nums.length-1, k-1);

    }

    private int findK(int[] nums, int left, int right, int k){

        if (left == right){
            return nums[left];
        }

        int p = partition(nums, left, right);

        if (p == k){
            return nums[p];
        }else if (k < p){
            return findK(nums, left, p-1, k);
        }else {
            return findK(nums, p+1, right, k);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int p = new Random().nextInt(right - left) + left;
        swap(nums, left, p);

        //[left+1...lt) > p ; [lt...i) < p
        int lt = left + 1;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > nums[left]){
                swap(nums, i, lt ++);
            }
        }
        swap(nums, left, lt - 1);
        return lt - 1;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }


    public static void main(String[] args) {

        int[] nums = new int[]{3,2,1,5,6,4};
        System.out.println(new Solution().findKthLargest(nums, 2));
        System.out.println(new Solution().findKthLargest2(nums, 2));

        int[] nums2 = new int[]{3,2,3,1,2,4,5,5,6};
        System.out.println(new Solution().findKthLargest(nums, 4));
        System.out.println(new Solution().findKthLargest2(nums, 4));
    }
}