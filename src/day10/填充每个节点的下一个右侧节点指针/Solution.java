package day10.填充每个节点的下一个右侧节点指针;


import java.util.LinkedList;
import java.util.Queue;

/**
 *功能描述: 填充每个节点的下一个右侧节点指针
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * 进阶：
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 * @return
 * */

class Node {
    int val;
    Node left;
    Node right;
    Node next;
}

class Solution {
    public Node connect(Node root) {

        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        int n = 0;

        queue.offer(root);
        n ++;

        while (!queue.isEmpty()){

            Node node = queue.poll();
            n --;

            if (n == 0){
                node.next = null;
            }else {
                node.next = queue.peek();
            }
            if (node.left != null){
                queue.offer(node.left);
                n ++;
            }
            if (node.right != null){
                queue.offer(node.right);
                n ++;
            }
        }

        return root;
    }
    public Node connect2(Node root) {
        if (root == null) return null;
        Node left = root.left;
        Node right = root.right;

        while (left != null){
            left.next = right;
            left = left.right;
            right = right.left;
        }

        connect2(root.left);
        connect2(root.right);
        return root;
    }
}