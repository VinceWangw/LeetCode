package day02.有效的字母异位词;

/**
 * 类名: Solution
 * 描述: TODO
 * 姓名: wangf
 * 日期: 2020-12-15 10:51
 **/
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] s1 = new int[26];
        int[] s2 = new int[26];

        for (int i = 0; i < s.length(); i++) {
            s1[s.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < t.length(); i++) {
            s2[t.charAt(i) - 'a'] += 1;
        }

        printArr(s1);
        System.out.println();
        printArr(s2);

        return s1.length == s2.length  && isEqual(s1, s2);
    }
    private boolean isEqual(int[] s1, int[] s2){
        for (int i = 0; i < s1.length; i++) {
            if (s1[i] != s2[i]) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(new Solution().isAnagram(s,t));
    }
    private void printArr(int[] nums){
        for (int num : nums){
            System.out.print(num + ", ");
        }
    }
}