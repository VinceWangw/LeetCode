package days.day15.插入排序;

import java.util.Scanner;

/**
 * 类名: Main 描述: TODO 姓名: 悟天 日期: 2020-12-28 15:51
 **/
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                int m = sc.nextInt();
                int[] nums = new int[m];
                for (int j = 0; j < m; j++) {
                    nums[j] = sc.nextInt();
                }
                insertSort(nums);
                for (int j = 0; j < m - 1; j++) {
                    System.out.print(nums[j] + " ");
                }
                System.out.println(nums[m - 1]);
            }
        }
    }

    private static void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                int j = i - 1;
                int temp = nums[i];
                while (j >= 0) {
                    if (nums[j] > temp) {
                        nums[j + 1] = nums[j];

                    } else {
                        break;
                    }
                    j--;
                }
                nums[j + 1] = temp;
            }
        }
    }
}
