package day2.删除链表中的节点;

import util.ListNode;

/**
 * 类名: Solution
 * 描述: TODO
 * 姓名: wangf
 * 日期: 2020-12-15 15:24
 **/

/**
 *功能描述: TODO
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。
 *
 * 输入：head = [4,5,1,9], node = 5
 * 输出：[4,1,9]
 * 解释：给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * @return
 * */

class Solution {
    public void deleteNode(ListNode node) {
        //无法获取上一个节点，故无法删除当前节点。
        //被删除的节点不是尾节点
        //直接取代下一个节点，然后删除下一个节点。
        //1. val取代
        node.val = node.next.val;
        //2. 索引取代
        node.next = node.next.next;
    }
}

