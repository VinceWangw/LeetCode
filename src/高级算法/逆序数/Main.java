package 高级算法.逆序数;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int[] nums = new int[m];
            for (int j = 0; j < m; j++) {
                nums[j] = sc.nextInt();
            }
            System.out.println(new Main().reversePairs(nums));
        }
    }

    public int reversePairs(int[] nums) {
        int len = nums.length;
        if (len < 2) { return 0; }
        int[] copy = new int[len];
        System.arraycopy(nums, 0, copy, 0, len);
        int[] temp = new int[len];
        return reversePairs(copy, 0, len - 1, temp);
    }

    private int reversePairs(int[] nums, int left, int right, int[] temp) {
        if (left == right) { return 0; }
        int mid = left + (right - left) / 2;
        int leftPairs = reversePairs(nums, left, mid, temp);
        int rightPairs = reversePairs(nums, mid + 1, right, temp);

        if (nums[mid] <= nums[mid + 1]) {
            return leftPairs + rightPairs;
        }

        int crossPairs = mergeAndCount(nums, left, mid, right, temp);
        return leftPairs + rightPairs + crossPairs;
    }

    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        if (right + 1 - left >= 0) {
            System.arraycopy(nums, left, temp, left, right + 1 - left);
        }

        int i = left;
        int j = mid + 1;
        int count = 0;
        for (int k = left; k <= right; k++) {

            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
                count += (mid - i + 1);
            }
        }
        return count;
    }

    /**
     * 在插入排序中添加计数同样可以实现
     * @param nums[]
     * @return int : 逆序数
     */
    private static int insertSort(int[] nums){

        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i-1]){
                int num = nums[i];
                int j = i - 1;
                while ( j >=0 ) {
                    if (nums[j] > num){
                        nums[j+1] = nums[j];
                        count ++;
                    }else {
                        break;
                    }
                    j --;
                }
                nums[j+1] = num;
            }
        }
        return count;
    }
}
