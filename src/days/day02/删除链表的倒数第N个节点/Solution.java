package days.day02.删除链表的倒数第N个节点;

import util.ListHelper;
import util.ListNode;
/**
 * 类名: Solution
 * 描述: TODO
 * 姓名: wangf
 * 日期: 2020-12-15 15:41
 **/

/**
 *功能描述: TODO
 * 给定一个链表，删除链表的倒数第n个节点，并且返回链表的头结点。
 *
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 *
 * @return
 * */
 
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        ListNode node = ListHelper.arrayToNode(nums);
        ListHelper.printList(node);
        node = new Solution().removeNthFromEnd(node,2);
        ListHelper.printList(node);
    }

}