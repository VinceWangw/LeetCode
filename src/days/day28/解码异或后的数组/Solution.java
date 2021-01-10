package days.day28.解码异或后的数组;

import java.util.Arrays;

class Solution {
    public int[] decode(int[] encoded, int first) {

        int n = encoded.length;
        int[] res = new int[n+1];
        res[0] = first;
        for (int i = 1; i < n + 1; i++) {
            res[i] = (encoded[i-1] ^ res[i-1]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] encodes = {6,2,7,3};
        System.out.println(Arrays.toString(new Solution().decode(encodes, 4)));
    }
}