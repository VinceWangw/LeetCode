package day2.字符串中的第一个唯一字符;

/**
 * 类名: Solution
 * 描述: TODO
 * 姓名: wangf
 * 日期: 2020-12-15 10:20
 **/

import org.omg.PortableInterceptor.INACTIVE;
import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *功能描述: TODO
 * s = "leetcode"
 * 返回 0
 * s = "loveleetcode"
 * 返回 2
 * @return
 * */

class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);
            if (map.containsKey(c)){
                map.put(c,-1);
            }else{
                map.put(c,i);
            }
        }
        int res = -1;
        for(int i : map.values()){
            if (i >= 0 && res == -1){
                res = i;
            }else if (i >= 0){
                res = Math.min(res,i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "";
        System.out.println("\n");
        System.out.println("min Index is : ");
        System.out.println(new Solution().firstUniqChar(s));
    }
}