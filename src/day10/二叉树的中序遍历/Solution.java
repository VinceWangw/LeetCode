package day10.二叉树的中序遍历;

import util.TreeNode;

import java.util.*;

/**
 * 功能描述:
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 * @return 
 * */
 
class Solution {
    /**
     *功能描述: 递归中序遍历，左 -> 根 -> 右
     * @param TreeNode
     * @return List<Integer>
     * */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null){
            return list;
        }

        list.addAll(inorderTraversal(root.left));
        list.add(root.val);
        list.addAll(inorderTraversal(root.right));

        return list;
    }

    /**
     *功能描述: 中序遍历使用迭代
     * @param root
     * @return java.util.List<java.lang.Integer>
     * */

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode rt = root;
        while (rt != null || !stack.isEmpty()){
            while (rt != null) {
                stack.push(rt);
                rt = rt.left;
            }

            rt = stack.pop();
            list.add(rt.val);
            rt = rt.right;
        }
        return list;
    }
}