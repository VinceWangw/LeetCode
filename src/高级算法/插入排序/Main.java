package 高级算法.插入排序;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i ++){
            int m = sc.nextInt();
            int[] nums = new int[m];
            for (int j = 0; j < m; j++) {
                nums[j] = sc.nextInt();
            }
            insertSort(nums);
            for (int j = 0; j < m - 1; j++) {
                System.out.print(nums[j] + " ");
            }
            System.out.println(nums[m-1]);
        }


    }

    private static void insertSort(int[] nums){

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
    }
}
