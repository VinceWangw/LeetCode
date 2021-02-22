package days;

public class Solution {

    public int maxProduct(int[] nums){

        int min = 1;
        int max = 1;
        int res = Integer.MIN_VALUE;

        for(int num : nums){
            if (num < 0){
                int temp = min;
                min = max;
                max = min;
            }
            max = Math.max(max, max * num);
            min = Math.min(min, min * num);

            res = Math.max(res, max);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProduct(new int[]{2, -1, 3}));
    }
}
