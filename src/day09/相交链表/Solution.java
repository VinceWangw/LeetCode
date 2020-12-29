package day09.相交链表;


import util.ListNode;

/**
 * Definition for singly-linked list.
 * public class util.ListNode {
 *     int val;
 *     util.ListNode next;
 *     util.ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode node1 = headA;
        ListNode node2 = headB;

        while (node1 != node2){

            if (node1 == node2){
                return node1;
            }

            node1 = node1 == null ? headB : node1.next;
            node2 = node2 == null ? headA : node2.next;
        }
        return node1;
    }
}