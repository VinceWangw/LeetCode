package classes.动态规划.l45跳跃游戏2;

public class Solution4 {

    public int jump(int[] nums) {

        int end = 0;
        int n = nums.length;
        if (n == 0 || n == 1){
            return 0;
        }
        int k = 0;
        int res = 0;

        for (int i = 0; i < n; i++) {

            k = Math.max(k, nums[i] + i);

            if (k >= n-1){
                return  ++ res;
            }

            if (i == end){
                end = k;
                res ++;
            }
        }
        return res;
    }
}
