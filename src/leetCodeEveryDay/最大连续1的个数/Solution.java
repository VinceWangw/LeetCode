package leetCodeEveryDay.最大连续1的个数;

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {

        int count = 0;
        int res = 0;
        for (int num : nums){
            if (num == 1){
                count ++;
            }else {
                res = Math.max(res, count);
                count = 0;
            }


        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
    }
}