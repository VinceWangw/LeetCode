package days.day28.交换链表中的节点;

import util.ListHelper;
import util.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapNodes(ListNode head, int k) {

        if (head.next == null){
            return head;
        }

        ListNode firstK = head;
        ListNode lastK = head;
        ListNode tail = head;
        for (int i = 0; tail!= null && i < k; i++) {
            tail = tail.next;
        }
        while (tail != null){
            lastK = lastK.next;
            tail = tail.next;
        }
        for (int i = 0; i < k - 1; i++) {
            firstK = firstK.next;
        }
        int temp = firstK.val;
        firstK.val = lastK.val;
        lastK.val = temp;

        return head;

    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        ListNode head = ListHelper.arrayToNode(nums);
        ListHelper.printList(head);
        head = new Solution().swapNodes(head, 2);
        ListHelper.printList(head);
    }
}