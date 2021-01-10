package days.day19.种花问题;


/**
 * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。
 * 可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * <p>
 * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数n。
 * 能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
 * <p>
 * 示例 1:
 * <p>
 * 输入: flowerbed = [1,0,0,0,1], n = 1
 * 输出: True
 * 示例 2:
 * <p>
 * 输入: flowerbed = [1,0,0,0,1], n = 2
 * 输出: False
 */
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int len = flowerbed.length;
        int i = -1;
        while (i < len) {
            if (i < 0 || flowerbed[i] == 0) {
                int j = i + 1;
                int k = i + 2;
                if (j < len && flowerbed[j] == 0){
                    if (k >= len || flowerbed[k] == 0){
                        n --;
                    }
                    i = j;
                }
            }
            i ++;
        }

        return n <= 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,0,0,0,1};
        System.out.println(new Solution().canPlaceFlowers(nums,1));
        System.out.println(new Solution().canPlaceFlowers(nums,2));
        System.out.println(new Solution().canPlaceFlowers(new int[]{1,0,0,0,0,0,1},2));
        System.out.println(new Solution().canPlaceFlowers(new int[]{0,0,0},2));
        System.out.println(new Solution().canPlaceFlowers(new int[]{0,0},2));
        System.out.println(new Solution().canPlaceFlowers(new int[]{0},1));
        System.out.println(new Solution().canPlaceFlowers(new int[]{0,0},1));
    }
}