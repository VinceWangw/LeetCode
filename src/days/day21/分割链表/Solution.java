package days.day21.分割链表;

import util.ListHelper;
import util.ListNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 示例：
 *
 * 输入：head = 1->4->3->2->5->2, x = 3
 * 输出：1->2->2->4->3->5
 *
 */

class Solution {
    public ListNode partition(ListNode head, int x) {

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode pre = dummy;
        Queue<ListNode> q = new ArrayDeque<>();
        dummy.next = head;
        while (head != null){
            ListNode next = head.next;
            if(head.val >= x){
                q.offer(head);
                pre.next = next;
                head = next;
                ListHelper.printList(dummy.next);
            }else {
                head = head.next;
                pre = pre.next;
            }

        }
        ListHelper.printList(dummy.next);
        ListHelper.printList(pre);
        ListHelper.printList(head);
        while (!q.isEmpty()){
            pre.next = q.poll();
            pre = pre.next;
        }
        pre.next = null;
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,4,3,2,5,2};
        ListNode head = ListHelper.arrayToNode(nums);
        ListHelper.printList(head);
        head = new Solution().partition(head, 3);
        ListHelper.printList(head);
    }
}