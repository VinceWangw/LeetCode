package days.day02.反转链表;

import util.ListHelper;
import util.ListNode;

/**
 * 类名: Solution
 * 描述: TODO
 * 姓名: wangf
 * 日期: 2020-12-15 16:00
 **/

/**
 *功能描述: TODO
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * @return
 * */
 
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode pre = null;
        while (head.next != null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        head.next = pre;
        return head;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        ListNode head = ListHelper.arrayToNode(nums);
        ListHelper.printList(head);
        head = new Solution().reverseList(head);
        ListHelper.printList(head);
    }
}