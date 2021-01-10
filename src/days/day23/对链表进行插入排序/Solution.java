package days.day23.对链表进行插入排序;


import util.ListHelper;
import util.ListNode;

class Solution {
    public ListNode insertionSortList(ListNode head) {

        if (head == null){
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy.next;

        while (pre.next != null){
            ListNode cur = pre.next;
            if (cur.val >= pre.val){
                pre = pre.next;
            }else {
                ListNode next = cur.next;
                pre.next = next;

                ListNode addPre = dummy;
                while (addPre.next.val < cur.val){
                    addPre = addPre.next;
                }

                ListNode addNext = addPre.next;
                addPre.next = cur;
                cur.next = addNext;


                ListHelper.printList(dummy.next);
            }

        }
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,5,4,3,2,100,0};
        ListNode head = ListHelper.arrayToNode(nums);
        ListHelper.printList(head);
        ListNode newHead = new Solution().insertionSortList(head);
        ListHelper.printList(newHead);

    }
}