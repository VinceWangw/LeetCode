package classes.数组;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        int n = A.length;
        Long num = 0L;
        List<Boolean> res = new ArrayList<>(n);
        
        for (int i = 0; i < n; i ++){
            num = num * 2 + A[i];
            System.out.println(num);
            if (num % 5 == 0){
                res.add(true);
            }else{
                res.add(false);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,0,1,1,1,1,0,0,0,0,1,0,0,0,0,0,1,0,0,
                1,1,1,1,1,0,0,0,0,1,1,1,0,0,0,0,0,
                1,0,0,0,1,0,0,1,1,1,1,1,1,0,1,1,0,1,0,0,0,0,0,0,1,0,1,1,1,0,0,1,0};
        new Solution().prefixesDivBy5(nums);
    }
}