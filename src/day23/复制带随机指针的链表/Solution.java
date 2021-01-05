package day23.复制带随机指针的链表;


import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}


class Solution {
    public Node copyRandomList(Node head) {

        Map<Node, Node> nodeNodeMap = new HashMap<>();

        Node curNode = head;
        while (curNode != null){
            Node nodeClone = new Node(curNode.val);
            nodeNodeMap.put( curNode, nodeClone);
            curNode = curNode.next;
        }
        curNode = head;
        while (curNode != null){

            nodeNodeMap.get(curNode).next = nodeNodeMap.get(curNode.next);
            nodeNodeMap.get(curNode).random = nodeNodeMap.get(curNode.random);
            curNode = curNode.next;

        }

        return nodeNodeMap.get(head);
    }
}