package day6.最长湍流子数组;


import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * 当 A的子数组A[i], A[i+1], ..., A[j]满足下列条件时，我们称其为湍流子数组：
 *
 * 若i <= k < j，当 k为奇数时，A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
 * 或 若i <= k < j，当 k 为偶数时，A[k] > A[k+1]，且当 k为奇数时，A[k] < A[k+1]。
 * 也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。
 *
 * 返回 A 的最大湍流子数组的长度。
 *
 * 示例 1：
 *
 * 输入：[9,4,2,10,7,8,8,1,9]
 * 输出：5
 * 解释：(A[1] > A[2] < A[3] > A[4] < A[5])
 *
 */
class Solution {
    public int maxTurbulenceSize(int[] arr) {

        int n = arr.length;

        //dp1[i]:以i结尾上升
        //dp0[i]:以i结尾下降
        int[] dp1 = new int[n];
        int[] dp0 = new int[n];

        dp1[0] = 1;
        dp0[0] = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i-1]) {
                dp1[i] = dp0[i-1] + 1;
                dp0[i] = 1;
            } else if (arr[i] < arr[i-1]) {
                dp0[i] = 1 + dp1[i-1];
                dp1[i] = 1;
            } else {
                dp0[i] = 1;
                dp1[i] = 1;
            }
        }

        int max = 0;
        for (int num : dp0){
            max = Math.max(num,max);
        }
        for (int num : dp1){
            max = Math.max(num, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9};
        System.out.println(new Solution().maxTurbulenceSize(nums));
    }
}