package util;

/**
 * 类名: util.ListHelper
 * 描述: TODO
 * 姓名: wangf
 * 日期: 2020-12-15 15:51
 **/
public class ListHelper {

    public static ListNode arrayToNode(int[] arr){
        ListNode head = new ListNode(arr[0]); // 把数组的第一个位置定义为头结点
        ListNode other = head; // 一个指针，此时指向头结点
        for(int i=1;i<arr.length;i++){ //头结点已经定义，从1开始
            ListNode temp = new ListNode(arr[i]);
            other.next = temp;
            other = other.next;

        }//在此处打印结点容易导致head的变化
        return head;
    }

    public static void printList(ListNode head){
        System.out.println();
        while (head != null){
            System.out.print(head.val + " -> ");
            head = head.next;
        }

        System.out.print("null");
    }
}
