package classes.动态规划.l45跳跃游戏2;
//给定一个非负整数数组，你最初位于数组的第一个位置。
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
//
// 输入: [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//    从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
// 说明:
//
// 假设你总是可以到达数组的最后一个位置。 
// Related Topics 贪心算法 数组 

//暴力搜索，超时
class Solution {
    public int jump(int[] nums) {

        //不断查找最远能到n位置的地方
        //2，3，1，1，4， 最远到4是1，res ++,  最远到1是3，res ++,
        //pos[3] - nums[0] < 2 , return 2;
        int n = nums.length;
        if (n == 0 || n == 1){
            return 0;
        }
        int end = n - 1;
        int res = 1;
        while (nums[0] < end){
            int minIndex = end ;

            for (int i = end - 1; i >= 0 ; i--) {
                if (nums[i] + i >= end){
                    minIndex = Math.min(minIndex, i);
                }
            }

            end = minIndex;
            res ++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().jump(new int[]{1,1,1,1}));
    }
}
