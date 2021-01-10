package days.day01.两个数组的交集2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * 类名: Solution
 * 描述: TODO
 * 姓名: wangf
 * 日期: 2020-12-14 15:57
 **/
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums1){
            if (map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            }
            else map.put(num, 1);
        }
        ArrayList<Integer> list = new ArrayList<>();

        for (int num : nums2){
            if (map.containsKey(num)){
                list.add(num);
                int times = map.get(num) - 1;
                if (times == 0){
                    map.remove(num);
                }else {
                    map.put(num,times);
                }
            }
        }

        int[] res = new int[list.size()];
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            for (int i = 0; i < list.size(); i++) {
                res[i] = (int)iterator.next();
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,56,2};
        int[] nums2 = new int[]{2,2,56,5,7};

        int[] res = new Solution().intersect(nums,nums2);
        System.out.println("\n");
        for (int num : res){

            System.out.print(num + ",");
        }
    }
}