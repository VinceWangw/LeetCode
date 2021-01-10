package days.day26.可被三整除的最大和;

/**
 * 给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。
 * <p>
 * 输入：nums = [3,6,5,1,8]
 * 输出：18
 * 解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。
 * <p>
 * 输入：nums = [4]
 * 输出：0
 * 解释：4 不能被 3 整除，所以无法选出数字，返回 0。
 * <p>
 * 输入：nums = [1,2,3,4,4]
 * 输出：12
 * 解释：选出数字 1, 3, 4 以及 4，它们的和是 12（可被 3 整除的最大和）。
 */
class Solution {
    public int maxSumDivThree(int[] nums) {

        int dpi0 = 0;
        int dpi1 = Integer.MIN_VALUE;
        int dpi2 = Integer.MIN_VALUE;

        for (int num : nums){
            int res = num % 3;
            switch (res) {
                case 0:{

                    int temp0 = dpi0;
                    int temp1 = dpi1;
                    int temp2 = dpi2;

                    dpi0 = Math.max(dpi0, temp0 + num);
                    dpi1 = Math.max(dpi1, temp1 + num);
                    dpi2 = Math.max(dpi2, temp2 + num);

                    break;
                }
                case 1:{

                    int temp0 = dpi0;
                    int temp1 = dpi1;
                    int temp2 = dpi2;

                    dpi0 = Math.max(dpi0, temp2 + num);
                    dpi1 = Math.max(dpi1, temp0 + num);
                    dpi2 = Math.max(dpi2, temp1 + num);

                    break;
                }
                default:{

                    int temp0 = dpi0;
                    int temp1 = dpi1;
                    int temp2 = dpi2;

                    dpi0 = Math.max(dpi0, temp1 + num);
                    dpi1 = Math.max(dpi1, temp2 + num);
                    dpi2 = Math.max(dpi2, temp0 + num);

                }
            }
        }
        return dpi0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxSumDivThree(new int[]{3, 6, 5, 1, 8}));
    }
}