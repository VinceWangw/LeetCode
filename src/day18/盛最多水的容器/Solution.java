package day18.盛最多水的容器;


/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器。
 * */
 
class Solution {
    public int maxArea(int[] height) {

        int max = 0;
        int left = 0, right = height.length - 1;

//        while (left < right){
//            int heightLeft = height[left];
//            int heightRight = height[right];
//            int curArea = Math.min(heightLeft, heightRight) * (right - left );
//            System.out.println("left = " + left + " right = " + right + " curArea = " +curArea);
//            max = Math.max(max, curArea);
//            if (height[left] < height[right]){
//                left ++;
//            }else {
//                right --;
//            }
//        }

        while(left < right){
            max = height[left] < height[right] ?
                    Math.max(max, (right - left) * height[left++]):
                    Math.max(max, (right - left) * height[right--]);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(new Solution().maxArea(height));
    }
}