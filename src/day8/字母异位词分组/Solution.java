package day8.字母异位词分组;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 *功能描述: TODO
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * @return
 * */

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        boolean[] used = new boolean[strs.length];
        Arrays.fill(used,false);

        for (int i = 0; i < strs.length; i++) {
            if (!used[i]){
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                used[i] = true;
                for (int j = i+1; j < strs.length; j++) {
                    if (!used[j] && isAnagrams(strs[i],strs[j])){
                        list.add(strs[j]);
                        used[j] = true;
                    }
                }
                res.add(list);
            }
        }

        return res;
    }


    private boolean isAnagrams(String str1, String str2) {
        if (str1.length() != str2.length()) { return false;}
        int[] st = new int[26];
        for (int i = 0; i < str1.length(); i ++){
            char c = str1.charAt(i);
            st[c-'a'] ++;
        }
        for (int i = 0; i < str2.length(); i++) {
            char c = str2.charAt(i);
            st[c-'a'] --;
        }
        for (int num : st) {
            if (num != 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] str1 = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = new Solution().groupAnagrams(str1);
        new Solution().printLists(lists);
    }


    private void printList(List<String> list){
        System.out.print("{ ");
        for (String i : list){
            System.out.print(i + ", ");
        }
        System.out.print("}" + ", " + "\n");
    }
    private void printLists(List<List<String>> lists){
        System.out.println("{");
        for (List<String> list : lists){
            printList(list);
        }
        System.out.println("}");
    }
}