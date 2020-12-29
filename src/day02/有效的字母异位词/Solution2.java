package day02.有效的字母异位词;

/**
 * 类名: Solution2
 * 描述: TODO
 * 姓名: wangf
 * 日期: 2020-12-15 11:05
 **/
class Solution2 {
    public boolean isAnagram(String s, String t) {
       if (s.length() != t.length()) return false;

       int[] nums = new int[26];
        for (int i = 0; i < s.length(); i++) {
            nums[s.charAt(i) - 'a'] ++;
        }
        //printArr(nums);
        for (int i = 0; i < t.length(); i++) {
            nums[t.charAt(i) - 'a'] -= 1;
            if (nums[t.charAt(i) - 'a'] < 0)
                return false;
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