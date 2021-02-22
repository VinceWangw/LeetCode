package leetCodeEveryDay.找到所有数组中消失的数字;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int curNum = nums[i];
            while (i + 1 != curNum && nums[curNum-1] != curNum){
                swap(nums, i, curNum-1);
                curNum = nums[i];
            }
        }

        System.out.println(Arrays.toString(nums));

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1){
                res.add(i + 1);
            }
        }
        return res;
    }

    private void swap(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
    }
}
class Solution2 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int curNum = Math.abs(nums[i]);
            nums[curNum - 1] *= nums[curNum - 1] > 0 ? -1 : 1;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0){
                res.add(i + 1);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(new Solution2().findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
    }
}