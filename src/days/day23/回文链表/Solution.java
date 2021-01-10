package days.day23.回文链表;

import util.ListHelper;
import util.ListNode;

class Solution {

    ListNode pre ;
    public boolean isPalindrome(ListNode head) {

        pre = head;
        return __isPalindrom(head);
    }

    private boolean __isPalindrom(ListNode cur){
        if (cur == null){
            return true;
        }

        if (!__isPalindrom(cur.next)){
            return false;
        }

//        if(cur == pre || cur.next == pre){
//            return true;
//        }

        int curVal = pre.val;
        pre = pre.next;
        return cur.val == curVal;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,2,1};
        System.out.println(new Solution().isPalindrome(ListHelper.arrayToNode(nums)));
    }
}